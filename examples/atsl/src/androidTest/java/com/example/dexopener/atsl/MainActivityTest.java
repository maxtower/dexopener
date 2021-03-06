/*
 * Copyright 2016 Tsuyoshi Murakami
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dexopener.atsl;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.intercepting.SingleActivityFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public final ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(new SingleActivityFactory<MainActivity>(MainActivity.class) {
                @Override
                protected MainActivity create(Intent intent) {
                    MainActivity testTarget = new MainActivity();
                    testTarget.myService = mock(MyService.class);
                    return testTarget;
                }
            }, /* initialTouchMode */ false, /* launchActivity */ false);

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

    @Test
    public void onCreate_should_call_MyService_doIt() {
        activityRule.launchActivity(null);
        verify(activityRule.getActivity().myService).doIt();
    }

}
