package cn.ainannan.sys.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ainannan.base.result.ResultGen;
import cn.ainannan.base.result.ResultObject;
import cn.ainannan.sys.user.bean.User;
import cn.ainannan.sys.user.bean.WxResult;
import cn.ainannan.sys.user.service.UserService;
import cn.ainannan.sys.utils.MyConfig;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="sys/login")
public class LoginController {
	@Autowired
	private MyConfig conf;
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public ResultObject list(String code){
		StringBuffer buffer = new StringBuffer();
		HttpURLConnection httpConn = null;
		BufferedReader reader = null;
		try {
			// url远程接口
			String strURL = conf.getUrl() + "?appid="+ conf.getAppID() 
							+"&secret=" + conf.getAppSecret() +"&js_code=" + code;
			
			URL url = new URL(strURL);
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpConn != null) {
				httpConn.disconnect();
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// json转换成对象
		JSONObject jsonObject = JSONObject.fromObject(buffer.toString());
		WxResult result = (WxResult)JSONObject.toBean(jsonObject, WxResult.class);
		System.out.println("测试：" + result);
		
		/*
		 * 逻辑梳理
		 * 先用openid去库里查询，如果已经存在则直接返回id，如果不存在则表示新用户，保存用户，然后返回id。
		 */
		User search = new User();
		search.setWxId(result.getOpenid());
		
		User resultUser = userService.getByWxId(search);
		if(resultUser == null) {
			resultUser = new User();
			resultUser.setAllocation(conf.getUserAllot());
			resultUser.setWxId(search.getWxId());
			resultUser.setLastLogin(new Date());
			resultUser.setState("1");
			userService.save(resultUser);
		} else {
			User user = new User();
			user.setId(resultUser.getId());
			user.setLastLogin(new Date());
			userService.save(user);
		}
		
		System.out.println("userId:" + resultUser.getId());
		
		return ResultGen.genSuccessResult(resultUser.getId());
	}
}
