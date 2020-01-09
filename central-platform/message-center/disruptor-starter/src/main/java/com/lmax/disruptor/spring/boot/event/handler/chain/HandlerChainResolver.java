package com.lmax.disruptor.spring.boot.event.handler.chain;

import com.lmax.disruptor.spring.boot.event.DisruptorEvent;

public interface HandlerChainResolver<T extends DisruptorEvent> {

	HandlerChain<T> getChain(T event , HandlerChain<T> originalChain);
	
}
