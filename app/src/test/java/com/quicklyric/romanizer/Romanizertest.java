package com.quicklyric.romanizer;

import junit.framework.Assert;

import org.junit.Test;

/**
 * This file is part of Romanizer
 * Created by geecko on 22/07/17.
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
public class Romanizertest {

    @Test
    public void testLRC() {
        String text = "[00:06.83]Gimme chocolate\n[00:43.81]あたたたたた　ずっきゅん　わたたたたた　どっきゅん\n[00:48.19]ずきゅん　どきゅん　ずきゅん　どきゅん\n[00:50.31]ヤダ　ヤダ　ヤダ　ヤダ　never, never, never\n[00:52.71]C, I, O, チョコレート　チョコレート　チョチョチョ いいかな?\n[00:57.03]でもね　ちょっと　weight　ちょっと最近　心配なんです\n[01:01.41]だけど　チョコレート　チョコレート　チョチョチョ いいかな?\n[01:05.82]でもね　ちょっと　wait　ちょっと待って　チョチョチョ\n[01:27.06]あたたたたた　ずっきゅん　わたたたたた　どっきゅん\n[01:31.84]ずきゅん　どきゅん　ずきゅん　どきゅん\n[01:33.87]マダ　マダ　マダ　マダ　never, never, never\n[01:36.07]C, I, O, チョコレート　チョコレート　チョチョチョ いいよね?\n[01:40.75]でもね　ちょっと weight　ちょっと最近　心配なんです\n[01:44.91]だけど　チョコレート　チョコレート　チョチョチョ いいよね?\n[01:49.50]でもね　ちょっと wait　ちょっと待って　チョチョチョ\n[01:58.00]Too, too late, too, too late\n[02:00.51]Too, too p, p, p, come on\n[02:45.63]あたたたたた　ずっきゅん　わたたたたた　どっきゅん\n[02:50.31]ずきゅん　どきゅん　ずきゅん　どきゅん\n[02:52.35]ヤダ　ヤダ　ヤダ　ヤダ　never, never, never\n[02:54.67]ヤバい　超超ハード　超イッパイ　頑張ったんです\n[02:59.26]だから　ちょっとハート　ちょっとだけ　お願いなんです\n[03:03.60]早く　チョコレート　チョコレート　チョチョチョ　ちょうだい\n[03:08.00]よこせ　チョコレート　チョコレート　プリーズ\n[03:12.56]C, I, O, チョコレート　チョコレート　チョチョチョ　いいでしょ?\n[03:16.59]だよね　超超good　超ハッピーで　頑張っちゃうんです\n[03:21.02]だから　チョコレート　チョコレート　チョチョチョ　いいでしょ?\n[03:25.41]だよね　ちょっとだけ　ちょっとだけ　食べちゃおう\n[03:34.15]Too, too late, too, too late\n[03:36.44]Too, too, p, p, p, come on\n";
        String output = RomanizerUtil.romanize(text, null);
        Assert.assertTrue(output.contains("43.81"));
        Assert.assertFalse(output.contains("  "));
        System.out.println(text);
        System.out.println(output);
    }

    @Test
    public void testKorean() {
        String text = "나빠요 참 그대라는 사람\n" + "허락도 없이 왜 내맘 가져요\n" + "그대 때문에 난 힘겹게 살고만 있는데\n" + "그댄 모르잖아요\n" + "\n" + "알아요 나는 아니란 걸\n" + "눈길줄만큼 보잘것 없단걸\n" + "다만 가끔씩 그저 그미소\n" + "여기 내게도 나눠줄 순 없나요\n" + "비록 사랑은 아니라도\n" + "\n" + "언젠가 한번쯤은 돌아봐주겠죠\n" + "한없이 뒤에서 기다리면\n" + "오늘도 차마 못한 가슴속 한마디\n" + "그대 사랑합니다\n" + "\n" + "어제도 책상에 엎드려\n" + "그댈 그리다 잠들었나봐요\n" + "눈을 떠보니 눈물에 녹아 흩어져있던\n" + "시린 그대이름과 헛된 바램뿐인 낙서만\n" + "\n" + "언젠가 한번쯤은 돌아봐주겠죠\n" + "한없이 뒤에서 기다리면\n" + "오늘도 차마 못한 가슴속 한마디\n" + "그대 사랑합니다\n" + "\n" + "이젠 너무나도 내게 익숙한\n" + "그대 뒷모습을 바라보며\n" + "흐르는 눈물처럼 소리없는 그말\n" + "그대 사랑합니다";
        String output = RomanizerUtil.romanize(text, null);
        Assert.assertTrue(output.contains("nabbayo cam "));
        Assert.assertTrue(output.contains("geudae sarangh"));
    }
}
