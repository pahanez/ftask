/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
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
package famtask.pahanez.com.familytask.view;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import famtask.pahanez.com.familytask.R;
import famtask.pahanez.com.familytask.view.fragment.AddTaskFragment;
import famtask.pahanez.com.familytask.view.fragment.MainViewFragment;

public class Navigator {

    private static final String ADD_TASK_FRAGMENT_TAG = "add_task_fragment_task";
    private static final String MAIN_VIEW_FRAGMENT_TAG = "main_view_fragment_task";

    private final Context mContext;
    private final FragmentManager mManager;

    @Inject
    public Navigator(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mManager = fragmentManager;
    }

    public void openTvShowActivity(final String tvShowId) {
//      context.ge
//    Intent intent = TvShowActivity.getLaunchIntent(context, tvShowId);
//    startActivity(intent);
    }


    public void openMainViewFragment() {
        Fragment fragment = mManager.findFragmentByTag(MAIN_VIEW_FRAGMENT_TAG);

        if (fragment != null) {
            openFragment(fragment, MAIN_VIEW_FRAGMENT_TAG);
        } else {
            openFragment(new MainViewFragment(), MAIN_VIEW_FRAGMENT_TAG);
        }
    }

    public void openCreateNewTaskFragment() {
        Fragment fragment = mManager.findFragmentByTag(ADD_TASK_FRAGMENT_TAG);

        if (fragment != null) {
            openFragment(fragment, ADD_TASK_FRAGMENT_TAG);
        } else {
            openFragment(new AddTaskFragment(), ADD_TASK_FRAGMENT_TAG);
        }
    }

    private void openFragment(Fragment fragment, String tag) {
        FragmentTransaction transaction = mManager.beginTransaction();
        transaction.replace(R.id.app_activity_container, fragment, tag);
        transaction.commit();
    }



    private void startActivity(Intent intent) {
        mContext.startActivity(intent);
    }
}
