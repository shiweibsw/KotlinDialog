最近已经开始全面转投kotlin，不得不说使用kotlin开发项目真的是非常舒服，编写代码过程中真的有一种所想即所得的感觉，不会在让一些无聊的东西打断你的思路，回归正题，这边介绍一下kotlin中的一个小技巧。

在我们平常开发过程中肯定会使用到各种progressDialog，最常见的请求网络数据时在没有返回数据会显示一个加载中的状态，大多是时候我们会封装一个CustomProgressdialog，当调用的时候初始化它，通过show方法进行显示，通常我们会把这个CustomProgressdialog放在BaseActivity中，方便各个界面进行调用，下面来看kotlin中是如何完成这些操作的。

首先需要一个CustomProgressdialog，先完成一个这种样式的CustomProgressdialog

![](http://upload-images.jianshu.io/upload_images/1179815-000dab00677be03f.gif?imageMogr2/auto-orient/strip)

这边文章的重点不在如何实现这个CustomProgressdialog，封装的具体过程就不说了，如果需要文末有github地址。

现在我们已经有了一个CustomProgressdialog，接下来自定义一个接口LoadingDialogManager

    interface LoadingDialogManager {

       val loadingDialog: LoadingDialog

       fun showLoadingDialog(context: Context) {
            loadingDialog.showDialog(context, "加载中", true, null)
        }

        fun hideLaodingDialog() {
            loadingDialog.dismiss()
        }
    }

在这个接口中有两个方法showLoadingDialog和hideLaodingDialog，对应dialog的show和dismiss。注意这里并没有对LoadingDialog进行实例化
下面让我们的BaseActivity实现这个接口，由于我们的接口中有一个loadingDialog成员，所有还需要实现它

    open class BaseActivity : AppCompatActivity(), LoadingDialogManager {
        override val loadingDialog by lazy { LoadingDialog(this) }
    }

这里使用到了委托延迟属性的概念，简单来说只有当loadingDialog 真正被使用的时候采实例化它。这样就减轻了activity初始化的压力。

在具体的activity中直接调用showLoadingDialog和hideLaodingDialog即可完成LoadingDialog的显示和隐藏了。

    class MainActivity : BaseActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            showLoadingDialog(this)
        }
    }

有没有感觉这样一封装代码变得简洁不少？其实这只是一种思路，其他的一些公用组件也可以通过这种方式进行封装，最后奉上githu地址
[https://github.com/shiweibsw/KotlinDialog](https://github.com/shiweibsw/KotlinDialog)

题外话：最近正在利用业余时间完全使用kotlin高仿一版B站客户端，目前正在开发过程中，欢迎有兴趣的小伙伴加入，github地址：[https://github.com/shiweibsw/iBiliPlayer-Kotlin](https://github.com/shiweibsw/iBiliPlayer-Kotlin)
