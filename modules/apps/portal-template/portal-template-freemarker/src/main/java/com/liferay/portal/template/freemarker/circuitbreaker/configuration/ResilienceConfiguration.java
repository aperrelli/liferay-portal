package com.liferay.portal.template.freemarker.circuitbreaker.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.template.freemarker.circuitbreaker.constants.CircuitBreakerConfigurationsConstants;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import java.time.Duration;
import java.util.Map;

/**
 * @author andersonperrelli
 */

@Component(
	configurationPid = CircuitBreakerConfigurationsConstants.CIRCUITBREAKER_CONFIG_ID,
	immediate = true,
	property = {},
	service = ResilienceConfiguration.class)
public class ResilienceConfiguration {

	private static final Log _log =
		LogFactoryUtil.getLog(ResilienceConfiguration.class);

	private volatile CircuitBreakerConfiguration _circuitBreakerConfiguration;

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_log.debug("Activate ResilienceConfiguration");
		_circuitBreakerConfiguration = ConfigurableUtil.createConfigurable(CircuitBreakerConfiguration.class, properties);
	}

	public CircuitBreaker createCircuitBreaker(final String name) {

		CircuitBreaker _circuitBreaker = CircuitBreaker.of(name,
			CircuitBreakerConfig.custom()
				.minimumNumberOfCalls(_circuitBreakerConfiguration.minimumNumberOfCalls())
				.failureRateThreshold(_circuitBreakerConfiguration.failureRateThreshold())
				.slowCallRateThreshold(_circuitBreakerConfiguration.slowCallRateThreshold())
				.waitDurationInOpenState(Duration.ofSeconds(_circuitBreakerConfiguration.waitDurationInOpenState()))
				.slowCallDurationThreshold(Duration.ofSeconds(_circuitBreakerConfiguration.slowCallDurationThreshold()))
				.build());

		return _circuitBreaker;
	}

}
