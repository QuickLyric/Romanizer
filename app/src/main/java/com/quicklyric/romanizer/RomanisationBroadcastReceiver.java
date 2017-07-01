package com.quicklyric.romanizer;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * This file is part of QuickLyricRomanizer
 * Created by geecko on 1/07/17.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class RomanisationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String[] inputs = intent.getExtras().getStringArray("input");
        String caller = intent.getExtras().getString("caller_package");
        String callerClass = intent.getExtras().getString("caller_class");

        if (inputs != null) {
            String[] outputs = new String[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                outputs[i] = RomanizerUtil.romanize(inputs[i]);
            }
            broadcast(context, outputs, caller, callerClass);
        }
        broadcast(context, null, caller, callerClass);
    }

    private void broadcast(Context context, String[] output, String caller, String callerClass) {
        Intent romanizedIntent = new Intent();
        romanizedIntent.setComponent(new ComponentName(caller, callerClass));
        romanizedIntent.setAction("com.geecko.QuickLyric.ROMANIZED_OUTPUT");
        romanizedIntent.putExtra("output", output);
        context.sendBroadcast(romanizedIntent);
    }
}
