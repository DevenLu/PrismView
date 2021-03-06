/*
* Copyright (C) 2015 Pedro Paulo de Amorim.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.github.ppamorim.prismview.sample.domain.model;

import com.github.ppamorim.prismview.sample.R;
import com.github.ppamorim.recyclerrenderers.interfaces.Renderable;

public class Vapor implements Renderable {

  private String url;
  private String title;

  public Vapor(String title, String url) {
    this.title = title;
    this.url = url;
  }

  public String getUrl() {
    return url;
  }

  public String getTitle() {
    return title;
  }

  @Override public int getRenderableResourceId(int i) {
    return R.layout.adapter_vapor;
  }

}
