<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
    import="java.util.*"
%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="/tags" prefix="date"%>

<head>
    <meta charset="utf-8">
    <title>职业</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/static/css-5/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/static/css-5/base.css" rel="stylesheet" type="text/css">
</head>

<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="">全部</a>
        <a class="nav-bar-a" href="">前端开发</a>
        <a class="nav-bar-a" href="">后端开发</a>
        <a class="nav-bar-a" href="">移动开发</a>
        <a class="nav-bar-a" href="">整站开发</a>
        <a class="nav-bar-a" href="">运营维护</a>
    </div>




    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">
       <c:forEach var="joblist" items="${jobList}">
            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                    <p>创建时间:<date:date value="${joblist.created_at}"/></p>
                    <p>更新时间:<date:date value="${joblist.updated_at}"/></p>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">${joblist.introduce}</p>
                </div>
            </div>

        </div>
        </c:forEach>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="${pageContext.request.contextPath}/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="${pageContext.request.contextPath}/static/images/687.png"></div>
                    <div class="text">
                        <h4 class="">Web前端工程师</h4>
                        <p class="text-present">Web前端开发工程师，主要职责是利用(X)HTML/CSS/JavaScript/flash等各种Web技术进行产品的开发。</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="${pageContext.request.contextPath}/static/images/xx.png"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="${pageContext.request.contextPath}/static/images/xx.png"><img src="/images/xx.png"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">1-3</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">345</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有286人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">iOS工程师</p>
                    <p class="flip-text">iOS是由苹果公司开发的移动操作统，iOS与苹果的Mac OS X操作系统一样， 也是以Darwin为基础的，因此同样属于类Unix的商业操作系统。国内iOS开发起步相对较晚， 人才培养机制更是远远跟不上市场发展速度。有限的iOS开发人才成了国内企业必争的资源。 国内iOS开发起步相对较晚，人才培养机制更是远远跟不上市场发展速度。 有限的iOS开发人才成了国内企业必争的资源。</p>
                </div>
            </div>

        </div>
    </div>
</div>
