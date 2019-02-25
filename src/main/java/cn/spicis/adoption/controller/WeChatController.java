package cn.spicis.adoption.controller;

import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.spicis.adoption.utils.CheckUtil;
import cn.spicis.adoption.utils.MessageFormat;
import cn.spicis.adoption.utils.MessageUtil;

@Controller
@RequestMapping("/weChat")
public class WeChatController {
	/**
	 * <h4>功能：[微信验证 ][2019年2月23日 下午10:01:14][创建人: zhichao]</h4>
	 * <h4></h4>
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/autoReturn.do",method =RequestMethod.GET)
	public String getMessageValidate(HttpServletRequest request, HttpServletResponse response){
		String signature = request.getParameter("signature");//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = request.getParameter("timestamp");//	时间戳
		String nonce = request.getParameter("nonce");//	随机数
		String echostr = request.getParameter("echostr");//	随机字符串

		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		
		return "";
	}
	
	/**
	 * <h4>功能：[接受消息,并返回消息 ][2019年2月23日 下午10:01:14][创建人: zhichao]</h4>
	 * <h4></h4>
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/autoReturn.do",method =RequestMethod.POST)
	public String getMessage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Map<String,String> map = new MessageFormat().xmlToMap(request);
		
		String fromUserName = map.get("FromUserName");//公众号
		String toUserName = map.get("ToUserName");//粉丝号
		String msgType = map.get("MsgType");//发送的消息类型[比如 文字,图片,语音。。。]
		String content = map.get("Content");//发送的消息内容
		String message = null;
		
		System.out.println("fromUserName："+fromUserName+"   ToUserName："+toUserName+"  MsgType："+msgType+"  "+content);
		
		//判断发送的类型是文本
		if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
			//发送的内容为???时
			if("主菜单".equals(content)){
				message = MessageFormat.initText(toUserName, fromUserName, MessageUtil.menuText());
			}else if("1".equals(content)) {
				Random random = new Random();
				message = MessageFormat.initText(toUserName, fromUserName, String.format("您本次的验证码为:%s%s%s%s", random.nextInt(10),random.nextInt(10),random.nextInt(10),random.nextInt(10)));//模拟验证码
			}else if("2".equals(content)) {
				message  = MessageFormat.initText(toUserName, fromUserName, "This is fucking life!");
			}else{
				message  = MessageFormat.initText(toUserName, fromUserName, "功能正在完善中,请按提示信息操作[回复'主菜单'显示主菜单]。");
			}
		}else if(MessageUtil.MESSAGE_EVENT.equals(msgType)){//验证是关注/取消事件
			String eventType = map.get("Event");//获取是关注还是取消
			//关注
			if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
				message = MessageFormat.initText(toUserName, fromUserName, "欢迎关注爪盟星,回复[主菜单]即可调出功能菜单");
			}
		}
		
		return message;
	
	}
	
	
}

