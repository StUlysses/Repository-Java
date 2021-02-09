package reaolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import myException.MyException;
/**
 * 全局异常处理器
 * @author CAOto
 *
 */
public class CustomerException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		String result = arg3.getMessage();
		if(arg3 instanceof MyException) {
			result = ((MyException)arg3).getMsg();
			System.out.println(result);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",result);
		mav.setViewName("msg");
		return mav;
	}

}
