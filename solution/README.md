# W02

学号：191220055
姓名：梁安泽



[toc]

## 任务一

###### 1、example中的类图及main方法中的对象时序图

类图：

![](http://www.plantuml.com/plantuml/png/RL8zpXCn4Etd52ut4ia1KaGXJHea8dveeXJUpH0M7E_AFq18A2WeQAWG7RHq20bH8S5bWEGOs9xFpaJADXxFyxnvytQcradZ_5O1GAiTciUoGN6drR9Mk0SHlkTTknOMtQAphMixNULWaE1y4nlsXA106BEFfF8OKgy16YMjBIM9FpSJYau0pbeHYWFWKYY96MJK8KEo2yDo9VgRq49kY5NGnZXxxpBPBKAOi332-VbzPrgz4QwxROpSyQdcYA_GK7EAXNk2555fPrn8sdG0UrSDs2MsUq1rXB2vYQ6YW-k9vk73Fiw0F1-7byRYGabTKOenuajilCC2X55G-wsOTzwiz-KNcX9jIbG3zxWudAQY-cXPz9ByBEauNWfcktjIFol6KgUOuIE_a7tPX5GLHR959IVOdgfEfixB5QS9hofkInGHBU6_R-RhMY4dJ3H2yhe-5C6blZmdexfRFyN6xI_tXGBg27crXiF3HD3piJZ-_FBltUy4HcHIx1sBls-_dzvy8EHA3G6ZqIJlx5Zy-VNfzECZP8fGLS121ydIK7VWsDVFn_VV2Bgk0cWt4qX-5OYGhEGi0xYxr93YqW_eVjsHAUgrtwh_)

时序图：

![](http://www.plantuml.com/plantuml/png/VL9DRm8X4BtpApRf1HBx1pmqrekN7apjny5umDrHIH4sVCJQNzy12gQHnOEmlFVWpPjPMCUDysVP4JBYJlHYvCfrwRVfGK5N0QJ0ynhWJh02-05JHQqsRWAw6345BVr-Bs4phLrfRuOgijPMEA4LWYGLyxXzM1a0jNjAHSox5roeK8uHgVNOaQ2RuexUKUHpz3EBaXB6ZLiUHRu5bxzetZ02QgZOAT6XxWZkBNzITa_EISx_XKDP-rPqyqTC2skxY8MzZw5WOAG0bLYSVZQ6NuFJMuPLGMnLAl23ImyeAHsiyGnNNpGbLdLGWf2Q3w6BsnthsiomPgVaDfLtJCphmiTmvwp3lvQ9SeWJmes5jUIARfmHwiZQPZ27G6uaLsaCV4Fl7PGNscd7H-9kUNqDSPR1RMb2xMLqurdIjCSWESeDkv-kYn5vR0y7C31ynWFA6jIuQJ8EqjjJaz5BRI64l41Z_Ym9-GK0)

###### 2、理解example

使用面向对象的机制实现example，好处是层级结构清晰，易于代码的修改和维护，同时还可以充分利用多态的特点。例如，如果需要实现任务三，只需定义Matrix类并将其定义为若干个Line组成的数组，这样便可利用Line类丰富的接口。

可改进之处：个人觉得应该把`swapPosition`方法放在Line类中实现，毕竟有行之后交换位置才变得更有意义，我实现任务二和任务三时就是这么做的。



## 任务二

###### 1、实现思路

定义一个长度为256的Line，其中每一个元素的r/g/b值均为随机值，他们的权重由rgb值计算而来。为了节约长度（完全使用rgb会得到一个很长的数，不方便查看），我决定将他们的权值进行压缩。

```java
Monster(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        setRank(((r << 16) + (g << 8) + b) / 2048); //权重 = rgb计算值 / 2048
    }												//问题不大 :D
```

至于排序算法，我实现了快速排序和选择排序，演示结果使用的是选择排序。

###### 2、类图及可视化结果

![](http://www.plantuml.com/plantuml/png/hLEzRXGn4Exz52utKf87kE8Kg4440bMKmhitXEKSxs9x-T4c1GK53HMYWvOE8I4g97WP87aCx9tnh1sTJXH9ivFvvllcnzyTEA-i7ywq4A8r7knZrO2yqnfLQnY537_FktOb7VW7ogohKBCpPKCWJocvKzGTTgxrRMUg522S_eki50VcXH2DLiunZarf0gdnAmg9Yj2oBoLdaAL31iP2uVX4zXGwaHe2RuUQ_U2Js2uZb8XRN2jtBrIVz2CqSuwyRSsfzDqjQzMhVEaZezOu6eRIFu4fm5HdFLZffe-Ogu82nt6GXqIwzX18h_1JJ1Ak2e_wk1pa-NWLPHqSQcKgJ6MAy1AQmGC1kqZcJUw6IuOs8vl3pZRXg9xHu9lI5Zq5k2V9qHtfbXUvHt6jpAAwKwjOVtoIdo5KLSNkqNvQ5TQxFTIrXbnmaf4gv_M19ChNJjDbKlU7jbd_dnA2yUA-zCpSv5bIOspB0CbIeA7nDxBClVffa1fB3sDGOSlqQzZRErzI-K9U_lZyz-sl2Op8ajzu8V-y-NRr-ZqY-_jBIVo5_FtpuzNt3o9L1Xg3p19aYi0ypz4ldoxVVMLmOqE1lvM8uMKOGO1cuK7AT36YOBVmA1Zp9BC7DkFuGbiA164Rhte0PZMSwNy0)

[![asciicast](https://asciinema.org/a/zV527xLR9DBPefpCRX1AXIme3.svg)](https://asciinema.org/a/zV527xLR9DBPefpCRX1AXIme3)



## 任务三

###### 1、实现思路

显然需要定义一个Matrix类。矩阵可以表示为Line的数组，于是乎我将Matrix类定义为Line的子类（当然他们之间是聚合关系）

```java
    int row;
    int col;
    Line[] theMatrix;
```

Matrix中的方法与Line基本一致，只是利用了Line的方法来辅助实现。这样可以尽可能少地修改代码，同时又能充分利用多态的特点。例如以下的put方法，其实是利用了Line的put方法辅助实现：

```java
    public void put(Linable linable, int row, int col) {
        theMatrix[row].put(linable, col);
    }											
```

至于排序算法，我是先将矩阵中的若干个行合并成一行，再进行排序。我实现了快速排序和选择排序，演示结果使用的是选择排序。



###### 2、类图及可视化结果

![](http://www.plantuml.com/plantuml/png/hLEzRXGn4Exz52utKf87kE8Kg4440bMKmhStXEMStSNsag1D2WeA6Yf41oqTGa9KIF0oGF8OZ7ViMVla0WcksRdvPhxvviS7rYdZXZCjX6XQ1-Qnga7UQLgrqZ0AYR_dNREM5jm3rMugZDcPl6Z8q-3SoU8EEzkufckhQ10S__ciQ6FcbH2rLjOoJaM30gdfApAAAg1vtU1aSAP63umPm_69x8DfHIm8t1rnzeEBPBkC18VlOYlSdgkU5I8qvnmvqxIdqdMtZ54lqgRlAeGkHfwewSxPhZlDob2lUm8KJNh9JkkKLPUL4_2lwezQjQ71akarJWQvEkF0I3jzn1o536nxCGz3qjOPKNf5dqm9tWGywdsJaFhzJfMnSAXLMv4hOOGBg0S70TYbv7aFU0TO9bd4VEHihMOKhpwx9xucwZFGqHpZBA_I5qPj9GzCTshjuuzFqZ5WL9NrZlEQ-akqtnvMkDQKSAAHAithCKdasuxg4ghxGrDl_ew9G3znbzrCelvPPCkneW0-AT1Gk__IpBtLKwGQynicewAIyKNixLqkG_X2Nd_x-FlrZmdqo99tl92_NdsvUVcMaFtzfGpv2_dp-_kRh-z4ZCGq1ZbBq8kbOfvYBXNE1JalqxnF7wxVV6QmA4NGA_8OpOmH0e9AbaZkedZ1TyHIo6ObytMKyMHtvG0HiEAy3w1T3sVw3m00)

[![asciicast](https://asciinema.org/a/ZCpjTTIdHy8GWHf5SWXbtVnnt.svg)](https://asciinema.org/a/ZCpjTTIdHy8GWHf5SWXbtVnnt)



## 实验收获&建议

这次实验收获还是很大的，不仅锻炼了面向对象的编程能力，同时也学习了wsl、asciinema等有趣的新事物。

建议曹哥在每次布置作业时增加一份提交参考目录，这样能方便批改。