package social.model.bean;

public class FriendInfoBeanWithProfile {
	private FriendInfoBean friendInfoBean;
	private String imageToJason;
	
	public FriendInfoBeanWithProfile() {
	}

	public FriendInfoBeanWithProfile(FriendInfoBean friendInfoBean, String imageToJason) {
		this.friendInfoBean = friendInfoBean;
		this.imageToJason = imageToJason;
	}

	public FriendInfoBean getFriendInfoBean() {
		return friendInfoBean;
	}

	public void setFriendInfoBean(FriendInfoBean friendInfoBean) {
		this.friendInfoBean = friendInfoBean;
	}

	public String getImageToJason() {
		return imageToJason;
	}

	public void setImageToJason(String imageToJason) {
		this.imageToJason = imageToJason;
	}

}