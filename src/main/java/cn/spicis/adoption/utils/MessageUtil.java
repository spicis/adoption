package cn.spicis.adoption.utils;

public class MessageUtil {
	/**
	 * ����
	 */
	public static final String MESSAGE_TEXT = "text";//�ı�
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
	 * <h4>���ܣ�[��ʾ�����˵� ][2019��2��23�� ����10:01:14][������: zhichao]</h4>
	 * <h4></h4>
	 * @return
	 */
	public static String menuText() {
		StringBuffer sb = new StringBuffer();
		sb.append("��ӭ����עצ����,�밴�ղ˵���ʾ���в���:\n\n");
		sb.append("[1].��ȡ��֤��\n");
		sb.append("[2].��ʾ������Ϣ\n");
		sb.append("[3].����צ����\n");
		sb.append("[4].���ڳ�Ϊ������\n\n");
		sb.append("�ظ� \"[���˵�]\" �����˲˵���");
		return sb.toString();
	}
}
