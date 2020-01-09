/*
 * Copyright (c) 2017, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.lmax.disruptor.spring.boot.event.translator;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.spring.boot.event.DisruptorBindEvent;
import com.lmax.disruptor.spring.boot.event.DisruptorEvent;
import com.lmax.disruptor.spring.boot.util.StringUtils;

public class DisruptorEventOneArgTranslator implements EventTranslatorOneArg<DisruptorEvent, DisruptorEvent> {

	@Override
	public void translateTo(DisruptorEvent event, long sequence, DisruptorEvent bind) {
		event.setSource(bind.getSource());
		event.setEvent(bind.getEvent());
		event.setTag(bind.getTag());
		event.setKey(StringUtils.hasText(bind.getKey()) ? bind.getKey() : String.valueOf(sequence));
		event.setBody(bind.getBody());
		if(event instanceof DisruptorBindEvent){
			DisruptorBindEvent bindEvent = (DisruptorBindEvent)event;
			bindEvent.bind(bind);
		}
	}
	
}
