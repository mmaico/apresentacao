package salesman.negotiation.infrastructure.libraries;


import net.vidageek.mirror.dsl.Mirror;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

public class HandlerErrors {

	private Set<String> errors = new HashSet<>();
	
	public HandlerErrors(Set<String> errors) {
		
		if (errors != null) {
			this.errors = errors;
		}	
	}

	public <T extends ValidationException> void throwing(Class<T> clazzException) {
		
		if (this.errors.isEmpty()) return;
		
		Constructor<T> constructor = new Mirror().on(clazzException).reflect().constructor().withArgs(Set.class);

		T instanceException = new Mirror()
				.on(clazzException)
				.invoke().constructor(constructor)
				.withArgs(errors);
		
		throw instanceException;
	}
	
	public static HandlerErrors hasErrors(Set<String> errors) {
		return new HandlerErrors(errors);
	}
}
