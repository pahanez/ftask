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
package famtask.pahanez.com.familytask.executor;

import com.pahanez.famtask.domain.executor.BackgroundExecutionThread;
import com.pahanez.famtask.domain.executor.MainExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(library = true)
public final class ExecutorModule {

  @Provides @Singleton
  BackgroundExecutionThread provideExecutor(BackThread backgroundExecutionThread) {
    return backgroundExecutionThread;
  }

  @Provides @Singleton
  MainExecutionThread provideMainThread(UIThread mainExecutionThread) {
    return mainExecutionThread;
  }
}
