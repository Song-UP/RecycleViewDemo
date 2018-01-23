package llapps.com.recycleviewdemo.util;

import android.content.Context;
import android.widget.Toast;

import llapps.com.recycleviewdemo.R;

/**
 * Created by wusong on 2018/1/23.
 */

public class Constance {
    public static int[] img1_1s = {R.drawable.img1_1, R.drawable.im11_1, R.drawable.img2_1,
            R.drawable.img3_1, R.drawable.img4_1,
            R.drawable.img5_1, R.drawable.img6_1, R.drawable.img7_1, R.drawable.img8_1, R.drawable.img9_1,
            R.drawable.img10_1};

    public static int[] img3_13s = {R.drawable.img1_13, R.drawable.img2_13, R.drawable.img3_13, R.drawable.img4_13,
            R.drawable.img5_13, R.drawable.img6_13, R.drawable.img7_13,
            R.drawable.img8_13, R.drawable.img1_13};

    static int a = 0;
    public static void showToast(Context context){
        int round = (int) Math.abs(Math.random()*15);
        String jitang = jiTangs[round];
        Toast.makeText(context, jitang, Toast.LENGTH_LONG).show();
    }


    public static String[] jiTangs= {
            " 转角一般不会遇到爱，只会遇到乞丐。",
            "你以为只要长得漂亮就有男生喜欢？你以为只要有了钱漂亮妹子就自己贴上来了？你以为学霸就能找到好工作？我告诉你吧，这些都是真的！",
            "我这张脸只要遮住两个地方就完美了！一处是右半边脸，另一处是左半边脸。",
            "对今天解决不了的事情，也不要着急。因为明天也可能还是解决不了。",
            "当你觉得自己又丑又穷，一无是处时，别绝望，因为至少你的判断还是对的。",
            "年轻人嘛，现在没钱算什么，以后没钱的日子还多着呢。",
            "别减肥了，你丑不仅是因为胖。",
            "所谓的女汉子，只不过是因为长得丑而已，但凡有些爷们气质的漂亮姑娘，都被称为女王大人。",
            "你总嫌有些人懒，说得好像你勤快了就真能干出什么大事儿一样。",
            "一个姑娘的介绍：思想上的女流氓，生活中的好姑娘，然而给我的感觉是：心思活络的丑逼。",
            "努力了这么久，但凡有点儿天赋，也该有些成功的迹象了。",
            "女生的冷暖自知什么的，在长的好看的面前都弱爆了。",
            "世上无难事只怕有钱人，物以类聚人以穷分。",
            "挣钱是一种能力，花钱是一种技术，我能力有限，技术却很高。",
            "别点啦，小心中毒太深"
    };




}
