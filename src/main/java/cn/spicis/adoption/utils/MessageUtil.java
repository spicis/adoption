package cn.spicis.adoption.utils;

public class MessageUtil {
	/**
	 * 类型
	 */
	public static final String MESSAGE_TEXT = "text";//文本
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE = "scancode_push";

	
	/**
	 * <h4>功能：[显示的主菜单 ][2019年2月23日 下午10:01:14][创建人: zhichao]</h4>
	 * <h4></h4>
	 * @return
	 */
	public static String menuText() {
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您关注爪盟星,请按照菜单提示进行操作:\n\n");
		sb.append("[1].获取验证码\n");
		sb.append("[2].显示个人信息\n");
		sb.append("[3].关于爪盟星\n");
		sb.append("[4].关于成为领养人\n\n");
		sb.append("回复 \"[主菜单]\" 调出此菜单。");
		return sb.toString();
	}
}
