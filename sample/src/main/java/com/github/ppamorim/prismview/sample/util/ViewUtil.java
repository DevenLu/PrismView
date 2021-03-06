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
package com.github.ppamorim.prismview.sample.util;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.github.ppamorim.prismview.sample.domain.model.Vapor;
import com.github.ppamorim.prismview.sample.domain.provider.VaporProvider;
import com.github.ppamorim.prismview.sample.ui.renderers.factory.VaporFactory;
import com.github.ppamorim.recyclerrenderers.adapter.RendererAdapter;
import com.github.ppamorim.recyclerrenderers.builder.RendererBuilder;

public class ViewUtil {

  public static void bind(final SimpleDraweeView view, String url) {
    if (url != null) {
      ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
          .setImageType(ImageRequest.ImageType.SMALL)
          .build();
      DraweeController draweeController = Fresco.newDraweeControllerBuilder()
          .setImageRequest(imageRequest)
          .setOldController(view.getController())
          .setAutoPlayAnimations(true)
          .build();
      view.setController(draweeController);
    }
  }

  public static void configRecyclerView(Context context, RecyclerView recyclerView) {
    recyclerView.setHasFixedSize(true);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    LinearLayoutManager layoutManager = new LinearLayoutManager(context);
    recyclerView.addItemDecoration(new MarginDecoration(context));
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(new RendererAdapter<Vapor>(VaporProvider.generateVapors(context),
        new RendererBuilder(new VaporFactory()), LayoutInflater.from(context)));
  }

}
