package com.estsoft.muvigram.injection.component;

import com.estsoft.muvigram.injection.PerSingleFragment;
import com.estsoft.muvigram.injection.module.SingleFragmentModule;
import com.estsoft.muvigram.ui.base.fragment.BaseSingleFragment;
import com.estsoft.muvigram.ui.camera.CameraFragment;
import com.estsoft.muvigram.ui.musicselect.injection.component.NestedFragmentComponent;
import com.estsoft.muvigram.ui.musicselect.injection.module.NestedFragmentModule;
import com.estsoft.muvigram.ui.musicselect.pager.MusicSelectFragment;
import com.estsoft.muvigram.ui.videocut.VideoCutFragment;
import com.estsoft.muvigram.ui.videoedit.VideoEditFragment;
import com.estsoft.muvigram.ui.videoselect.VideoSelectFragment;

import dagger.Subcomponent;

/**
 * In android's perspective :
 *
 * In dagger's perspective :
 *
 * In DI's perspective :
 *
 *
 * Created by jaylim on 10/31/2016.
 */

@PerSingleFragment
@Subcomponent(modules = SingleFragmentModule.class)
public interface SingleFragmentComponent {
    /* Subcomponent */
    NestedFragmentComponent plus(NestedFragmentModule nestedFragmentModule);

    /* Dependencies from provider */
    // TODO ...

    /* Dependencies from constructor injection */
    // TODO ...

    /* Field injection */
    void inject(BaseSingleFragment baseSingleFragment);
    void inject(MusicSelectFragment musicSelectFragment);

    void inject(CameraFragment cameraFragment);

    void inject(VideoSelectFragment videoSelectFragment);
    void inject(VideoEditFragment videoEditFragment);
    void inject(VideoCutFragment videoCutFragment);
}
