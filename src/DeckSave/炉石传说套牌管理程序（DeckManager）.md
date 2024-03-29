# **炉石传说套牌管理程序（DeckManager）**

## 主要功能

### 1.把套牌代码导入数据库

  分析出套牌名字，职业，模式，简略代码

### 2.从数据库中查询套牌并导出

  1）支持根据名字，职业，模式查找
  2）选择导出后，将套牌代码复制到剪切板

## 实现类

### 一、套牌管理类

#### 1.Deck

套牌类，包含套牌名字，职业，模式，套牌代码，简略代码属性。

#### 2.DeckAnalytic

分析套牌编码，把套牌名字，职业，模式，简略代码分析出来，保存到套牌类。

#### 3.DeckController

连接数据库，负责数据库的操作，有导入和查找两个方法

#### 4.DeckFace

把管理套牌的方法打包一下，交给其他类使用

### 二、界面类

#### 1.MainInterface

主界面，用JTapped类做了两个标签页，第一个实现导入套牌，第二个实现查找套牌

#### 2.InputInterface

导入界面，继承JPanel类，一个文本框用于输入套牌编码，一个导入按钮，点击导入按钮后导入套牌。考虑用文本区实现套牌导入，更加直观，但要用Document类分析，有个想法是先存到文件里，然后再用套牌分析类分析文件。

#### 3.PasteListener

导入监听器，点击导入按钮后，把文本框的内容转成字符串，发送给套牌分析类

#### 4.SelectInterface

查找外观类，有一个输入关键词的文本框，然后输出一个查找出的套牌列表，每个列表后面放一个复制套牌按钮，点击后可以复制套牌代码到剪切板

#### 5.SelectListener

查找套牌监听器，先把文本框里的关键词发送给套牌管理器，去把查出的套牌类数组返回来，然后用表格组件，显示每一个套牌的数据，如果表格可以加button的话就直接加，不能加就用GrildLayout显示。