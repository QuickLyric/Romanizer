package com.quicklyric.romanizer;

import android.content.BroadcastReceiver;
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
        String[] inputs = intent.getExtras().getStringArray("inputs");

        if (inputs != null) {
            String[] outputs = new String[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                outputs[i] = RomanizerUtil.romanize(inputs[i]);
            }
            broadcast(context, outputs);
        }
        broadcast(context, null);
    }

    private void broadcast(Context context, String[] output) {
        Intent romanisedIntent = new Intent();
        romanisedIntent.setAction("com.geecko.QuickLyric.ROMANIZED_OUTPUT");
        romanisedIntent.putExtra("output", output);
        context.sendBroadcast(romanisedIntent);
        System.exit(0);
    }
}
