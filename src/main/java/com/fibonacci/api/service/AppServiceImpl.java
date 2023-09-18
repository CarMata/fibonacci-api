package com.fibonacci.api.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AppServiceImpl implements AppService{

	@Override
	public Integer executeFibonacci(Integer n) {
		log.info("proceso fibonacci - ejecutando");
		int fib = 0;
		try {
			if (n <= 0) {
				fib = 0;
			} else if (n == 1) {
				fib = 1;
			} else {
				
				int prev1 = 1;
				int prev2 = 0;

				for (int i = 2; i <= n; i++) {
					fib = prev1 + prev2;
					prev2 = prev1;
					prev1 = fib;
				}
			}
		} catch (Exception e) {
			log.error("proceso fibonacci - error",e.getMessage()!= null ? e.getMessage() : e.getLocalizedMessage());
		}
		log.info("proceso fibonacci - ejecutado");
		return fib;
	}

}
