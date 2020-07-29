package com.example.firstandroiddevelopment
/*
* MainActivity管理主界面
* 所有代码都在这里面写
* 具体的界面需要在layout文件里面去配置
* */
import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//通过setContentView实现layout与activity产生联系
        /*
        * 为登录按钮设置点击事件的方法
        * 当有多个按钮的时候可以使用这个方法
        * 但这是Java的常用方法
        * */
        //loginbutton.setOnClickListener(this)
        /*
        * Kotlin的方法
        * lambda表达式
        * */
//        loginbutton.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                println("按钮2被点击了")
//            }
//        })//匿名对象的方法
//        loginbutton.setOnClickListener({view:View? ->
//            println("按钮3被点击了")
//        })
//    }//lambda表达式
//        loginbutton.setOnClickListener{ view: View? ->
//            println("按钮4被点击了")
//        }
    loginbutton.setOnClickListener{
        println("按钮5被点击了")
        ObjectAnimator.ofFloat(pic1,"rotation",0f,360f).also {
            it.duration = 100//用0.1秒完成一次动画
            it.repeatCount = 20//转20圈（20次动画）
            it.start()//动画开始
            it.addListener(object : Animator.AnimatorListener{
                override fun onAnimationRepeat(p0: Animator?) {}
                override fun onAnimationEnd(p0: Animator?) {
                    startActivity(Intent(this@MainActivity,Activity2::class.java))//点击登录,动画完毕后跳转至下一个界面
                }
                override fun onAnimationCancel(p0: Animator?) {}
                override fun onAnimationStart(p0: Animator?) {}
            })
        }//添加动画

    }//最简单的版本
}
    override fun onClick(p0: View?) {
        println("按钮1被点击了")
    }//重写View.OnClickListener中的方法
}




