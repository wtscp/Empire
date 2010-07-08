/*
 * Copyright (c) 2009-2010 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.clarkparsia.empire.test.api;

import com.clarkparsia.empire.SupportsRdfId;
import com.clarkparsia.empire.annotation.SupportsRdfIdImpl;

import javax.persistence.PrePersist;
import javax.persistence.PostPersist;
import javax.persistence.PreRemove;
import javax.persistence.PostRemove;
import javax.persistence.PreUpdate;
import javax.persistence.PostUpdate;
import javax.persistence.PostLoad;
import javax.persistence.MappedSuperclass;

import java.net.URI;

/**
 * <p>Utility base class for testing</p>
 *
 * @author Michael Grove
 */
@MappedSuperclass
public class BaseTestClass implements SupportsRdfId {
	public boolean preUpdateCalled = false;
	public boolean postUpdateCalled = false;
	public boolean preRemoveCalled = false;
	public boolean postRemoveCalled = false;
	public boolean prePersistCalled = false;
	public boolean postPersistCalled = false;
	public boolean postLoadCalled = false;

	private SupportsRdfId mIdSupport = new SupportsRdfIdImpl();

	public RdfKey getRdfId() {
		return mIdSupport.getRdfId();
	}

	public void setRdfId(final RdfKey theId) {
		mIdSupport.setRdfId(theId);
	}

	public void clearState() {
		prePersistCalled = preRemoveCalled = preUpdateCalled = false;
		postLoadCalled = postPersistCalled = postRemoveCalled = postUpdateCalled = false;
	}

	@PrePersist
	public void onPrePersist() {
		prePersistCalled = true;
	}

	@PostPersist
	public void onPostPersist() {
		postPersistCalled = true;
	}

	@PreRemove
	public void onPreRemove() {
		preRemoveCalled = true;
	}

	@PostRemove
	public void onPostRemove() {
		postRemoveCalled = true;
	}

	@PreUpdate
	public void onPreUpdate() {
		preUpdateCalled = true;
	}

	@PostUpdate
	public void onPostUpdate() {
		postUpdateCalled = true;
	}

	@PostLoad
	public void onPostLoad() {
		postLoadCalled = true;
	}
}
