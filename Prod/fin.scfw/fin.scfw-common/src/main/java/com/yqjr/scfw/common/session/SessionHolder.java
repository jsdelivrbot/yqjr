package com.yqjr.scfw.common.session;

/**
 * User: Kyll
 * Date: 2018-01-29 20:46
 */
public class SessionHolder extends SessionContext {
	private static final String USER_CONTEXT_KEY = "userContext";

	static {
		SessionContext.setContextClass(SessionHolder.class);
	}

	public SessionHolder() {
		super();
	}

	public static SessionHolder getCurrentHolder() {
		return (SessionHolder) SessionContext.threadLocal.get();
	}

	public void setUserContext(UserContext userContext) {
		set(USER_CONTEXT_KEY, userContext);
	}

	public static UserContext getUserContext() {
		return (UserContext) getCurrentHolder().get(USER_CONTEXT_KEY);
	}


	/**
	 * 获取当前用户id
	 *
	 * @return
	 */
	public static Long getUserId() {
		if(getUserContext()==null || getUserContext().getId()==null)
			return null;
		return Long.valueOf(getUserContext().getId());
	}
	/**
	 * 获取当前用户公司
	 *
	 * @return
	 */
	public static String getCompany() {
		if(getUserContext()==null || getUserContext().getId()==null)
			return null;
		return getUserContext().getComCode();
	}

}
