package io.pivotal.literx;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;

/**
 * Learn how to create Flux instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="http://projectreactor.io/docs/core/release/api/reactor/core/publisher/Flux.html">Flux Javadoc</a>
 */
public class Part01Flux {

//========================================================================================

	//Return an empty Flux
	Flux<String> emptyFlux() {
		return Flux.empty();
	}

//========================================================================================

	//Return a Flux that contains 2 values "foo" and "bar" without using an array or a collection
	Flux<String> fooBarFluxFromValues() {
		return Flux.just("foo","bar");
	}

//========================================================================================

	//Create a Flux from a List that contains 2 values "foo" and "bar"
	Flux<String> fooBarFluxFromList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");
        return Flux.fromIterable(list);
	}

//========================================================================================

	//Create a Flux that emits an IllegalStateException
	Flux<String> errorFlux() {
		return Flux.error(new IllegalStateException());
	}

//========================================================================================

    //Create a Flux that emits increasing values from 0 to 9 each 100ms
	Flux<Long> counter() {
        // If 10 is not mentioned, Flux emits more events after 0-9
		return Flux.interval(Duration.ofMillis(100)).take(10);
	}
}
