package com.central.cms.commons.constant;


public class Enumerations {

	public enum ActiveState {
		正常(1), 禁用(0);
		Integer state;

		ActiveState(Integer state) {
			this.state = state;
		}

		public Integer getState() {
			return state;
		}

		public static ActiveState getActiveState(Integer type) {
			switch (type) {
				case 1:
					return 正常;
				case 0:
					return 禁用;
				default:
					return null;
			}
		}
	}

	public enum ResultCode {
		成功(200), 失败(300);
		Integer code;

		ResultCode(Integer code) {
			this.code = code;
		}

		public Integer getCode() {
			return code;
		}

		public static ResultCode getResultCode(Integer code) {
			switch (code) {
				case 200:
					return 成功;
				case 300:
					return 失败;
				default:
					return null;
			}
		}
	}

	public enum HttpType {
		HTTP("http"), HTTPS("https");
		String type;

		private HttpType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public static HttpType getHttpType(String type) {
			switch (type) {
				case "http":
					return HTTP;
				case "https":
					return HTTPS;
				default:
					return null;
			}
		}
	}
}
