package com.quicklyric.romanizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
        List<String> profiles = new ArrayList<>();
        if (!RomanizerUtil.areProfilesLoaded()) {
            try {
                profiles.add(readJsonFromAssets(context.getAssets().open("profiles/ja")));
                profiles.add(readJsonFromAssets(context.getAssets().open("profiles/zh-tw")));
                profiles.add(readJsonFromAssets(context.getAssets().open("profiles/zh-cn")));
                profiles.add(readJsonFromAssets(context.getAssets().open("profiles/ko")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (inputs != null) {
            String[] outputs = new String[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                outputs[i] = RomanizerUtil.romanize(inputs[i], profiles);
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

    private String readJsonFromAssets(InputStream is) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = is.read();
            while (i != -1)
            {
                byteArrayOutputStream.write(i);
                i = is.read();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}
