/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.util.gallery3d111.filtershow.history;

import android.graphics.Bitmap;
import android.util.gallery3d111.filtershow.pipeline.ImagePreset;

import android.util.gallery3d111.filtershow.filters.FilterRepresentation;

public class HistoryItem {
    private static final String LOGTAG = "HistoryItem";
    private ImagePreset mImagePreset;
    private FilterRepresentation mFilterRepresentation;
    private Bitmap mPreviewImage;

    public HistoryItem(ImagePreset preset, FilterRepresentation representation) {
        mImagePreset = preset; // just keep a pointer to the current preset
        if (representation != null) {
            mFilterRepresentation = representation.copy();
        }
    }

    public ImagePreset getImagePreset() {
        return mImagePreset;
    }

    public FilterRepresentation getFilterRepresentation() {
        return mFilterRepresentation;
    }

    public Bitmap getPreviewImage() {
        return mPreviewImage;
    }

    public void setPreviewImage(Bitmap previewImage) {
        mPreviewImage = previewImage;
    }

}
