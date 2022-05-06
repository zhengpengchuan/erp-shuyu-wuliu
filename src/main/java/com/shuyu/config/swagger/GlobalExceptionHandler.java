package com.shuyu.config.swaager;

import com.zc.basic.common.constant.ErrorCodeEnum;
import com.zc.common.core.dto.Response;
import com.zc.common.core.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmer);
	}


	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handleNotifyException(BusinessException e) {

		return Response.buildFailure(e.getErrCode(), e.getErrMessage());
	}

	/**
	 * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
	 */
	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Response bindException(BindException e) {

		log.error(e.getMessage(), e);

		return Response.buildFailure(ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
	}


	/**
	 * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
	 *
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.error(e.getMessage(), e);
		return Response.buildFailure(ErrorCodeEnum.PARAM_ERROR.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());
	}

	/**
	 * 参数类型转化失败异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handleMethodArgumentNotValidException(MethodArgumentTypeMismatchException e) {

		log.error(e.getMessage(), e);
		return Response.buildFailure(ErrorCodeEnum.PARAM_ERROR.getCode(), ErrorCodeEnum.PARAM_ERROR.getMessage());
	}


	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response exception(Exception e) {
		log.error(e.getMessage(), e);

		return Response.buildFailure(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode(), ErrorCodeEnum.INTERNAL_SERVER_ERROR.getMessage());
	}

	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response handleParamIsNullException(Exception ex){
		return Response.buildFailure(ErrorCodeEnum.PARAM_NULL_ERROR.getCode(), ex.getMessage());
	}

}
