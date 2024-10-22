/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import io.rollout.client.ConfigurationFetchedHandler;
import io.rollout.client.FetcherResults;
import io.rollout.client.FetcherStatus;
import io.rollout.rox.server.Rox;
import io.rollout.rox.server.RoxOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

import java.util.concurrent.ExecutionException;

/**
 * PetClinic Spring Boot Application.
 *
 * @author Dave Syer
 *
 */
@SpringBootApplication
@ImportRuntimeHints(PetClinicRuntimeHints.class)
public class PetClinicApplication {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		SpringApplication.run(PetClinicApplication.class, args);

		// Initialize container class that we created earlier
		Flags flags = new Flags();
		// Register the flags container with Rollout
		Rox.register(flags);
		// Building options
		RoxOptions options = new RoxOptions.Builder()
			.withConfigurationFetchedHandler(new ConfigurationFetchedHandler() {
				@Override
				public void onConfigurationFetched(FetcherResults fetcherResults) {
					if (fetcherResults != null) {
						FetcherStatus status = fetcherResults.getFetcherStatus();
						// configuration loaded from network, flags value updated
						if (status != null && status == FetcherStatus.AppliedFromNetwork) {
							System.out.println("flags value updated");
						}
					}
				}
			})
			.build();

		// Setup the Rollout environment key
	    // @naqh01 commenting out Rox.setup("66fe9bb334863653de479a9e", options).get();
	    // @nash01 pointing to cloudbees.io
		Rox.setup("4428b893-9511-47eb-7c05-a95f62ba4e23").get();

		
		// Boolean flag example
		if (flags.enableTutorial.isEnabled()) {
			// TODO:  Put your code here that needs to be gated
		}
		// String flag example
		String titleColor = flags.titleColors.getValue();
		System.out.printf("Title color is %s\n", titleColor);
		// Integer flag example
		int titleSize = flags.titleSize.getValue();
		System.out.printf("Title size is %d\n", titleSize);
		// Double flag example
		double specialNumber = flags.specialNumber.getValue();
		System.out.printf("Special number is %f\n", specialNumber);
		// Enum flag example
		Flags.Color color = flags.titleColorsEnum.getValue();
		System.out.printf("Enum color is %s\n", color.name());

	}
}


