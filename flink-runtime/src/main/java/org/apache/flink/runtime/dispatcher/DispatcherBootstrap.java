/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.runtime.dispatcher;

import org.apache.flink.annotation.Internal;

/**
 * An interface containing the logic of bootstrapping the {@link Dispatcher} of a cluster.
 */
@Internal
public interface DispatcherBootstrap {

	/**
	 * Initializes the {@link Dispatcher} provided as an argument.
	 *
	 * <p>IMPORTANT: In HA settings, this method will run during
	 * the initialization of the **leader** dispatcher.
	 *
	 * @param dispatcher the dispatcher to be initialized.
	 */
	void initialize(final Dispatcher dispatcher) throws Exception;

	/**
	 * Stops and frees any resources (e.g. threads) acquired
	 * by the {@link #initialize(Dispatcher)}.
	 */
	void stop() throws Exception;
}