/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.util.gallery3d111.filtershow.filters;

import com.android.gallery3d111.R;

import android.graphics.Bitmap;

public class ImageFilterSaturated extends SimpleImageFilter {
    private static final String SERIALIZATION_NAME = "SATURATED";
    public ImageFilterSaturated() {
        mName = "Saturated";
    }

    @Override
    public FilterRepresentation getDefaultRepresentation() {
        FilterBasicRepresentation representation =
                (FilterBasicRepresentation) super.getDefaultRepresentation();
        representation.setName("Saturated");
        representation.setSerializationName(SERIALIZATION_NAME);
        representation.setFilterClass(ImageFilterSaturated.class);
        representation.setTextId(R.string.saturation);
        representation.setMinimum(-100);
        representation.setMaximum(100);
        representation.setDefaultValue(0);
        representation.setSupportsPartialRendering(true);
        return representation;
    }

    native protected void nativeApplyFilter(Bitmap bitmap, int w, int h, float saturation);

    @Override
    public Bitmap apply(Bitmap bitmap, float scaleFactor, int quality) {
        if (getParameters() == null) {
            return bitmap;
        }
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int p = getParameters().getValue();
        float value = 1 +  p / 100.0f;
        nativeApplyFilter(bitmap, w, h, value);
        return bitmap;
    }
}
