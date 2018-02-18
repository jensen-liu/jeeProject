package com.jensen.jeeproject.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseResult {
	public static final String RESPONSE_FAIL = "fail";

	public static final String RESPONSE_SUCC = "ok";

	/**
	 * 调用接口状态 ok=成功，fail=失败
	 */
	private String result = "ok";
	/**
	 * 错误代码、说明
	 */
	private Map<String, ?> respMap = null;
	/**
	 * 错误代码、说明
	 */
	private List<?> respList = null;
	/**
	 * 错误代码、说明
	 */
	private Object respObject = null;

	public ResponseResult() {
	}

	private String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private Map<String, ?> getRespMap() {
		return null == respMap ? new HashMap<String, Object>() : this.respMap;
	}

	public void setRespMap(Map<String, ?> respMap) {
		this.respMap = respMap;
	}

	private List<?> getRespList() {
		return null == respList ? new ArrayList<Object>() : this.respList;
	}

	public void setRespList(List<?> respList) {
		this.respList = respList;
	}

	private Object getRespObject() {
		return null == respObject ? new Object() : this.respObject;
	}

	public void setRespObject(Object respObject) {
		this.respObject = respObject;
	}

	/**
	 * @Title: returnRespons
	 * @Description: 返回用户响应信息
	 * @author wz
	 * @date 2016年11月8日
	 * @since V1.0
	 * @param code
	 * @param msg
	 * @return
	 */
	public String toSuccessString() {

		this.setResult(ResponseResult.RESPONSE_SUCC);
		this.setRespMap(null);

		return this.toStringForMap();
	}

	/**
	 * 
	 * 返回返回用户响应信息<br/>
	 * {key:value}
	 * 
	 * @Title: toSuccessString
	 * @Description:
	 * @author hu
	 * @date 2017年11月8日 下午7:36:50
	 * @since V1.0
	 * @param key
	 * @param value
	 * @return
	 * @return String 返回类型
	 */
	public String toSuccessString(String key, String value) {

		Map<String, String> msg = new HashMap<String, String>();
		msg.put(key, value);

		this.setResult(ResponseResult.RESPONSE_SUCC);
		this.setRespMap(msg);

		return this.toStringForMap();
	}

	/**
	 * 返回失败提示信息 @Title: toFailString @param respCode @param respMsg @return
	 * String @author wl @date 2017年10月22日 @version V1.0 @throws
	 */
	public String toFailString(final String respCode, final String respMsg) {

		this.setResult(ResponseResult.RESPONSE_FAIL);
		Map<String, Object> msg = new HashMap<String, Object>() {
			{
				put("code", respCode);
				put("msg", respMsg);
			}
		};
		this.setRespMap(msg);

		return this.toStringForMap();
	}

	/**
	 * 返回失败提示信息 @Title: toFailString @param respMsg @return String @author
	 * wl @date 2017年10月24日 @version V1.0 @throws
	 */
	public String toFailString(final String respMsg) {

		this.setResult(ResponseResult.RESPONSE_FAIL);
		Map<String, Object> msg = new HashMap<String, Object>() {
			{
				put("msg", respMsg);
			}
		};
		this.setRespMap(msg);

		return this.toStringForMap();
	}

	@Override
	public String toString() {

		Map<String, Object> resultJSON = new HashMap<String, Object>();
		resultJSON.put("result", this.getResult());

		if (null != this.respObject) {
			return this.toStringForObject();
		}

		if (null != this.respList) {
			return this.toStringForList();
		}
		return this.toStringForMap();
	}

	/**
	 * 针对Map类型的响应体 修改说明： JSONObject.fromObject(resultJSON)容易造成嵌套死循环
	 * 更改为JsonMapper.toJsonString(resultJSON)，
	 * 
	 * @return JSON字符串
	 */
	public String toStringForMap() {

		Map<String, Object> resultJSON = new HashMap<String, Object>();
		resultJSON.put("result", this.getResult());
		resultJSON.put("response", this.getRespMap());
		return JsonMapper.toJsonString(resultJSON);
		// return JSONObject.fromObject(resultJSON).toString() ;
	}

	/**
	 * 针对Object类型的响应体 修改说明： JSONObject.fromObject(resultJSON)容易造成嵌套死循环
	 * 更改为JsonMapper.toJsonString(resultJSON)，
	 * 
	 * @return JSON字符串
	 */
	public String toStringForObject() {

		Map<String, Object> resultJSON = new HashMap<String, Object>();
		resultJSON.put("result", this.getResult());
		resultJSON.put("response", this.getRespObject());
		// return JSONObject.fromObject(resultJSON).toString() ;
		return JsonMapper.toJsonString(resultJSON);
	}

	/**
	 * 针对List类型的响应体 修改说明： JSONObject.fromObject(resultJSON)容易造成嵌套死循环
	 * 更改为JsonMapper.toJsonString(resultJSON)，
	 * 
	 * @return JSON字符串
	 */
	public String toStringForList() {

		Map<String, Object> resultJSON = new HashMap<String, Object>();
		resultJSON.put("result", this.getResult());
		resultJSON.put("response", this.getRespList());
		// return JSONObject.fromObject(resultJSON).toString() ;
		return JsonMapper.toJsonString(resultJSON);
	}

	public static void main(String[] args) {

		ResponseResult vo = new ResponseResult();
		// vo.getRespMap().put("account", new
		// Account("wz","wz","123","13668809698",1l)) ;

		// List<Object> list = new ArrayList<Object>(){{
		// add(new Account("wz","wz","123","13668809698",1l)) ;
		// add(new Account("wz","wz","123","13668809698",1l)) ;
		// add(new Account("wz","wz","123","13668809698",1l)) ;
		// add(new Account("wz","wz","123","13668809698",1l)) ;
		// add(new Account("wz","wz","123","13668809698",1l)) ;
		// }
		// };
		// vo.setRespList(list);

		// vo.setRespObject(new Account("wz","wz","123","13668809698",1l));
		// System.out.println(vo.toString());
		System.out.println(vo.toFailString("-1", "响应信息"));
		vo = new ResponseResult();
		vo.setRespObject("success");
		System.out.println(vo.toString());
	}
}
