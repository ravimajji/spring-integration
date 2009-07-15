/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.samples.filecopy;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Common functionality for the file demo.
 * 
 * @author Oleg Zhurakousky
 */
public class FileCopyDemoCommon implements BeanFactoryPostProcessor {

	public void afterPropertiesSet() {
		String tmpDirPath = System.getProperty("java.io.tmpdir");
		File parentDir = new File(tmpDirPath + File.separator + "spring-integration-samples");
		File outDir = new File(parentDir, "output");
		if (outDir.exists() || outDir.mkdirs()) {
			System.out.println("output directory is: " + outDir.getAbsolutePath());
		}
		else {
			System.err.println("failed to create directories within tmp dir: " + tmpDirPath);
		}
	}
	/**
	 * HACK!!!!!
	 */
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
		this.afterPropertiesSet();
	}
}
