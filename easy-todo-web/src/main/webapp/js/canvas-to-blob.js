


<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>JavaScript-Canvas-to-Blob/js/canvas-to-blob.js at master · blueimp/JavaScript-Canvas-to-Blob</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <link rel="logo" type="image/svg" href="https://github-media-downloads.s3.amazonaws.com/github-logo.svg" />
    <meta property="og:image" content="https://github.global.ssl.fastly.net/images/modules/logos_page/Octocat.png">
    <meta name="hostname" content="github-fe121-cp1-prd.iad.github.net">
    <meta name="ruby" content="ruby 1.9.3p194-tcs-github-tcmalloc (2012-05-25, TCS patched 2012-05-27, GitHub v1.0.36) [x86_64-linux]">
    <link rel="assets" href="https://github.global.ssl.fastly.net/">
    <link rel="xhr-socket" href="/_sockets" />
    
    


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="813258d7-1e12-4926-bf72-5adbad753146" name="octolytics-dimension-request_id" /><meta content="706817" name="octolytics-actor-id" /><meta content="ztreal" name="octolytics-actor-login" /><meta content="6ed7a56a4d9f9d97c709ee621116abeb9bf765a37daa00f7f3993a7353be35d0" name="octolytics-actor-hash" />
    

    
    
    <link rel="icon" type="image/x-icon" href="/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="a0mps1ihCbjmpnbjzSrc2tpN5ZH+Xt1HrVe5JszQfjc=" name="csrf-token" />

    <link href="https://github.global.ssl.fastly.net/assets/github-8d13b140cf7e2873c4dd1e0f589136f0e71bd381.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://github.global.ssl.fastly.net/assets/github2-d75c750a6b14571dc070b6570d9224acd7b6795e.css" media="all" rel="stylesheet" type="text/css" />
    


      <script src="https://github.global.ssl.fastly.net/assets/frameworks-f86a2975a82dceee28e5afe598d1ebbfd7109d79.js" type="text/javascript"></script>
      <script src="https://github.global.ssl.fastly.net/assets/github-8bc497b5a25db3bbde9d9735f49063fd1b82fedf.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="9e591fe846fcd7a162a579c1264e8ab9">

        <link data-pjax-transient rel='permalink' href='/blueimp/JavaScript-Canvas-to-Blob/blob/1a2fb2e4adfb7cecc7824c254fcf65018e85a913/js/canvas-to-blob.js'>
  <meta property="og:title" content="JavaScript-Canvas-to-Blob"/>
  <meta property="og:type" content="githubog:gitrepository"/>
  <meta property="og:url" content="https://github.com/blueimp/JavaScript-Canvas-to-Blob"/>
  <meta property="og:image" content="https://github.global.ssl.fastly.net/images/gravatars/gravatar-user-420.png"/>
  <meta property="og:site_name" content="GitHub"/>
  <meta property="og:description" content="JavaScript-Canvas-to-Blob - JavaScript Canvas to Blob is a function to convert canvas elements into Blob objects."/>

  <meta name="description" content="JavaScript-Canvas-to-Blob - JavaScript Canvas to Blob is a function to convert canvas elements into Blob objects." />

  <meta content="244586" name="octolytics-dimension-user_id" /><meta content="blueimp" name="octolytics-dimension-user_login" /><meta content="3412723" name="octolytics-dimension-repository_id" /><meta content="blueimp/JavaScript-Canvas-to-Blob" name="octolytics-dimension-repository_nwo" /><meta content="true" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="3412723" name="octolytics-dimension-repository_network_root_id" /><meta content="blueimp/JavaScript-Canvas-to-Blob" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/blueimp/JavaScript-Canvas-to-Blob/commits/master.atom" rel="alternate" title="Recent Commits to JavaScript-Canvas-to-Blob:master" type="application/atom+xml" />

  </head>


  <body class="logged_in  env-production macintosh vis-public page-blob">
    <div class="wrapper">
      
      
      


      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    <div class="divider-vertical"></div>

    
    <a href="/notifications" class="notification-indicator tooltipped downwards" data-gotokey="n" title="You have no unread notifications">
        <span class="mail-status all-read"></span>
</a>    <div class="divider-vertical"></div>


      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">

<input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    
    data-username="ztreal"
      data-repo="blueimp/JavaScript-Canvas-to-Blob"
      data-branch="master"
      data-sha="ad4e7ae37f17b2b54a43a158b972c06e09d977b1"
  >

    <input type="hidden" name="nwo" value="blueimp/JavaScript-Canvas-to-Blob" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item js-this-repository-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item js-all-repositories-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="octicon help tooltipped downwards" title="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

</form>
        <ul class="top-nav">
          <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="https://help.github.com">Help</a></li>
        </ul>
      </div>

    


  <ul id="user-links">
    <li>
      <a href="/ztreal" class="name">
        <img height="20" src="https://2.gravatar.com/avatar/893d5eeb644915f283f7c2bd070dc0f4?d=https%3A%2F%2Fidenticons.github.com%2Fbffca23967cdc17a5c26e1a87320233f.png&amp;s=140" width="20" /> ztreal
      </a>
    </li>

      <li>
        <a href="/new" id="new_repo" class="tooltipped downwards" title="Create a new repo" aria-label="Create a new repo">
          <span class="octicon octicon-repo-create"></span>
        </a>
      </li>

      <li>
        <a href="/settings/profile" id="account_settings"
          class="tooltipped downwards"
          aria-label="Account settings "
          title="Account settings ">
          <span class="octicon octicon-tools"></span>
        </a>
      </li>
      <li>
        <a class="tooltipped downwards" href="/logout" data-method="post" id="logout" title="Sign out" aria-label="Sign out">
          <span class="octicon octicon-log-out"></span>
        </a>
      </li>

  </ul>

<div class="js-new-dropdown-contents hidden">
  

<ul class="dropdown-menu">
  <li>
    <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
  </li>
  <li>
    <a href="/organizations/new"><span class="octicon octicon-organization"></span> New organization</a>
  </li>



    <li class="section-title">
      <span title="blueimp/JavaScript-Canvas-to-Blob">This repository</span>
    </li>
    <li>
      <a href="/blueimp/JavaScript-Canvas-to-Blob/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
    </li>
</ul>

</div>


    
  </div>
</div>

      

      




          <div class="site" itemscope itemtype="http://schema.org/WebPage">
    
    <div class="pagehead repohead instapaper_ignore readability-menu">
      <div class="container">
        

<ul class="pagehead-actions">

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" class="js-social-container" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="a0mps1ihCbjmpnbjzSrc2tpN5ZH+Xt1HrVe5JszQfjc=" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="3412723" />

    <div class="select-menu js-menu-container js-select-menu">
        <a class="social-count js-social-count" href="/blueimp/JavaScript-Canvas-to-Blob/watchers">
          29
        </a>
      <span class="minibutton select-menu-button with-count js-menu-target" role="button" tabindex="0">
        <span class="js-select-button">
          <span class="octicon octicon-eye-watch"></span>
          Watch
        </span>
      </span>

      <div class="select-menu-modal-holder">
        <div class="select-menu-modal subscription-menu-modal js-menu-content">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container" role="menu">

            <div class="select-menu-item js-navigation-item selected" role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for discussions in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item " role="menuitem" tabindex="0">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

  <li>
  
<div class="js-toggler-container js-social-container starring-container ">
  <a href="/blueimp/JavaScript-Canvas-to-Blob/unstar" class="minibutton with-count js-toggler-target star-button starred upwards" title="Unstar this repo" data-remote="true" data-method="post" rel="nofollow">
    <span class="octicon octicon-star-delete"></span><span class="text">Unstar</span>
  </a>
  <a href="/blueimp/JavaScript-Canvas-to-Blob/star" class="minibutton with-count js-toggler-target star-button unstarred upwards" title="Star this repo" data-remote="true" data-method="post" rel="nofollow">
    <span class="octicon octicon-star"></span><span class="text">Star</span>
  </a>
  <a class="social-count js-social-count" href="/blueimp/JavaScript-Canvas-to-Blob/stargazers">186</a>
</div>

  </li>


        <li>
          <a href="/blueimp/JavaScript-Canvas-to-Blob/fork" class="minibutton with-count js-toggler-target fork-button lighter upwards" title="Fork this repo" rel="nofollow" data-method="post">
            <span class="octicon octicon-git-branch-create"></span><span class="text">Fork</span>
          </a>
          <a href="/blueimp/JavaScript-Canvas-to-Blob/network" class="social-count">74</a>
        </li>


</ul>

        <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title public">
          <span class="repo-label"><span>public</span></span>
          <span class="mega-octicon octicon-repo"></span>
          <span class="author">
            <a href="/blueimp" class="url fn" itemprop="url" rel="author"><span itemprop="title">blueimp</span></a></span
          ><span class="repohead-name-divider">/</span><strong
          ><a href="/blueimp/JavaScript-Canvas-to-Blob" class="js-current-repository js-repo-home-link">JavaScript-Canvas-to-Blob</a></strong>

          <span class="page-context-loader">
            <img alt="Octocat-spinner-32" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
          </span>

        </h1>
      </div><!-- /.container -->
    </div><!-- /.repohead -->

    <div class="container">

      <div class="repository-with-sidebar repo-container ">

        <div class="repository-sidebar">
            

<div class="repo-nav repo-nav-full js-repository-container-pjax js-octicon-loaders">
  <div class="repo-nav-contents">
    <ul class="repo-menu">
      <li class="tooltipped leftwards" title="Code">
        <a href="/blueimp/JavaScript-Canvas-to-Blob" aria-label="Code" class="js-selected-navigation-item selected" data-gotokey="c" data-pjax="true" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /blueimp/JavaScript-Canvas-to-Blob">
          <span class="octicon octicon-code"></span> <span class="full-word">Code</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

        <li class="tooltipped leftwards" title="Issues">
          <a href="/blueimp/JavaScript-Canvas-to-Blob/issues" aria-label="Issues" class="js-selected-navigation-item js-disable-pjax" data-gotokey="i" data-selected-links="repo_issues /blueimp/JavaScript-Canvas-to-Blob/issues">
            <span class="octicon octicon-issue-opened"></span> <span class="full-word">Issues</span>
            <span class='counter'>1</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>        </li>

      <li class="tooltipped leftwards" title="Pull Requests"><a href="/blueimp/JavaScript-Canvas-to-Blob/pulls" aria-label="Pull Requests" class="js-selected-navigation-item js-disable-pjax" data-gotokey="p" data-selected-links="repo_pulls /blueimp/JavaScript-Canvas-to-Blob/pulls">
            <span class="octicon octicon-git-pull-request"></span> <span class="full-word">Pull Requests</span>
            <span class='counter'>0</span>
            <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>


    </ul>
    <div class="repo-menu-separator"></div>
    <ul class="repo-menu">

      <li class="tooltipped leftwards" title="Pulse">
        <a href="/blueimp/JavaScript-Canvas-to-Blob/pulse" aria-label="Pulse" class="js-selected-navigation-item " data-pjax="true" data-selected-links="pulse /blueimp/JavaScript-Canvas-to-Blob/pulse">
          <span class="octicon octicon-pulse"></span> <span class="full-word">Pulse</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped leftwards" title="Graphs">
        <a href="/blueimp/JavaScript-Canvas-to-Blob/graphs" aria-label="Graphs" class="js-selected-navigation-item " data-pjax="true" data-selected-links="repo_graphs repo_contributors /blueimp/JavaScript-Canvas-to-Blob/graphs">
          <span class="octicon octicon-graph"></span> <span class="full-word">Graphs</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>

      <li class="tooltipped leftwards" title="Network">
        <a href="/blueimp/JavaScript-Canvas-to-Blob/network" aria-label="Network" class="js-selected-navigation-item js-disable-pjax" data-selected-links="repo_network /blueimp/JavaScript-Canvas-to-Blob/network">
          <span class="octicon octicon-git-branch"></span> <span class="full-word">Network</span>
          <img alt="Octocat-spinner-32" class="mini-loader" height="16" src="https://github.global.ssl.fastly.net/images/spinners/octocat-spinner-32.gif" width="16" />
</a>      </li>
    </ul>


  </div>
</div>

            <div class="only-with-full-nav">
              

  

<div class="clone-url "
  data-protocol-type="http"
  data-url="/users/set_protocol?protocol_selector=http&amp;protocol_type=clone">
  <h3><strong>HTTPS</strong> clone URL</h3>

  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/blueimp/JavaScript-Canvas-to-Blob.git" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/blueimp/JavaScript-Canvas-to-Blob.git" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url open"
  data-protocol-type="ssh"
  data-url="/users/set_protocol?protocol_selector=ssh&amp;protocol_type=clone">
  <h3><strong>SSH</strong> clone URL</h3>

  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="git@github.com:blueimp/JavaScript-Canvas-to-Blob.git" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="git@github.com:blueimp/JavaScript-Canvas-to-Blob.git" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>

  

<div class="clone-url "
  data-protocol-type="subversion"
  data-url="/users/set_protocol?protocol_selector=subversion&amp;protocol_type=clone">
  <h3><strong>Subversion</strong> checkout URL</h3>

  <div class="clone-url-box">
    <input type="text" class="clone js-url-field"
           value="https://github.com/blueimp/JavaScript-Canvas-to-Blob" readonly="readonly">

    <span class="js-zeroclipboard url-box-clippy minibutton zeroclipboard-button" data-clipboard-text="https://github.com/blueimp/JavaScript-Canvas-to-Blob" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>



<p class="clone-options">You can clone with
    <a href="#" class="js-clone-selector" data-protocol="http">HTTPS</a>,
    <a href="#" class="js-clone-selector" data-protocol="ssh">SSH</a>,
    <a href="#" class="js-clone-selector" data-protocol="subversion">Subversion</a>,
  and <a href="https://help.github.com/articles/which-remote-url-should-i-use">other methods.</a>
</p>

  <a href="github-mac://openRepo/https://github.com/blueimp/JavaScript-Canvas-to-Blob" class="minibutton sidebar-button">
    <span class="octicon octicon-device-desktop"></span>
    Clone in Desktop
  </a>


                <a href="/blueimp/JavaScript-Canvas-to-Blob/archive/master.zip"
                   class="minibutton sidebar-button"
                   title="Download this repository as a zip file"
                   rel="nofollow">
                  <span class="octicon octicon-cloud-download"></span>
                  Download ZIP
                </a>
            </div>
        </div><!-- /.repository-sidebar -->

        <div id="js-repo-pjax-container" class="repository-content context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:e45563a6d2f1b8c2d3cf4b818e26efbc -->
<!-- blob contrib frag key: views10/v8/blob_contributors:v21:e45563a6d2f1b8c2d3cf4b818e26efbc -->

<p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

<a href="/blueimp/JavaScript-Canvas-to-Blob/find/master" data-pjax data-hotkey="t" style="display:none">Show File Finder</a>

<div class="file-navigation">
  


<div class="select-menu js-menu-container js-select-menu" >
  <span class="minibutton select-menu-button js-menu-target" data-hotkey="w"
    data-master-branch="master"
    data-ref="master"
    role="button" aria-label="Switch branches or tags" tabindex="0">
    <span class="octicon octicon-git-branch"></span>
    <i>branch:</i>
    <span class="js-select-button">master</span>
  </span>

  <div class="select-menu-modal-holder js-menu-content js-navigation-container" data-pjax>

    <div class="select-menu-modal">
      <div class="select-menu-header">
        <span class="select-menu-title">Switch branches/tags</span>
        <span class="octicon octicon-remove-close js-menu-close"></span>
      </div> <!-- /.select-menu-header -->

      <div class="select-menu-filters">
        <div class="select-menu-text-filter">
          <input type="text" aria-label="Filter branches/tags" id="context-commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Filter branches/tags">
        </div>
        <div class="select-menu-tabs">
          <ul>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
            </li>
            <li class="select-menu-tab">
              <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
            </li>
          </ul>
        </div><!-- /.select-menu-tabs -->
      </div><!-- /.select-menu-filters -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="branches">

        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/blueimp/JavaScript-Canvas-to-Blob/blob/gh-pages/js/canvas-to-blob.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="gh-pages" data-skip-pjax="true" rel="nofollow" title="gh-pages">gh-pages</a>
            </div> <!-- /.select-menu-item -->
            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/blueimp/JavaScript-Canvas-to-Blob/blob/master/js/canvas-to-blob.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="master" data-skip-pjax="true" rel="nofollow" title="master">master</a>
            </div> <!-- /.select-menu-item -->
        </div>

          <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

      <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket" data-tab-filter="tags">
        <div data-filterable-for="context-commitish-filter-field" data-filterable-type="substring">


            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/blueimp/JavaScript-Canvas-to-Blob/tree/2.0.7/js/canvas-to-blob.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="2.0.7" data-skip-pjax="true" rel="nofollow" title="2.0.7">2.0.7</a>
            </div> <!-- /.select-menu-item -->
            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <a href="/blueimp/JavaScript-Canvas-to-Blob/tree/2.0.6/js/canvas-to-blob.js" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="2.0.6" data-skip-pjax="true" rel="nofollow" title="2.0.6">2.0.6</a>
            </div> <!-- /.select-menu-item -->
        </div>

        <div class="select-menu-no-results">Nothing to show</div>
      </div> <!-- /.select-menu-list -->

    </div> <!-- /.select-menu-modal -->
  </div> <!-- /.select-menu-modal-holder -->
</div> <!-- /.select-menu -->

  <div class="breadcrumb">
    <span class='repo-root js-repo-root'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/blueimp/JavaScript-Canvas-to-Blob" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">JavaScript-Canvas-to-Blob</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/blueimp/JavaScript-Canvas-to-Blob/tree/master/js" data-branch="master" data-direction="back" data-pjax="true" itemscope="url"><span itemprop="title">js</span></a></span><span class="separator"> / </span><strong class="final-path">canvas-to-blob.js</strong> <span class="js-zeroclipboard minibutton zeroclipboard-button" data-clipboard-text="js/canvas-to-blob.js" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
  </div>
</div>


  
  <div class="commit file-history-tease">
    <img class="main-avatar" height="24" src="https://secure.gravatar.com/avatar/188943e53857bfaca6a5cf4328866e5d?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png" width="24" />
    <span class="author"><a href="/blueimp" rel="author">blueimp</a></span>
    <time class="js-relative-date" datetime="2013-06-26T16:56:00-07:00" title="2013-06-26 16:56:00">June 26, 2013</time>
    <div class="commit-title">
        <a href="/blueimp/JavaScript-Canvas-to-Blob/commit/2d7dfec4d1c252570bd750e4668ce2612aaff0c8" class="message" data-pjax="true" title="Refactored files organization.

Added bower.json.">Refactored files organization.</a>
    </div>

    <div class="participation">
      <p class="quickstat"><a href="#blob_contributors_box" rel="facebox"><strong>1</strong> contributor</a></p>
      
    </div>
    <div id="blob_contributors_box" style="display:none">
      <h2 class="facebox-header">Users who have contributed to this file</h2>
      <ul class="facebox-user-list">
        <li class="facebox-user-list-item">
          <img height="24" src="https://secure.gravatar.com/avatar/188943e53857bfaca6a5cf4328866e5d?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png" width="24" />
          <a href="/blueimp">blueimp</a>
        </li>
      </ul>
    </div>
  </div>


<div id="files" class="bubble">
  <div class="file">
    <div class="meta">
      <div class="info">
        <span class="icon"><b class="octicon octicon-file-text"></b></span>
        <span class="mode" title="File Mode">file</span>
          <span>96 lines (93 sloc)</span>
        <span>3.771 kb</span>
      </div>
      <div class="actions">
        <div class="button-group">
                <a class="minibutton tooltipped leftwards"
                   title="Clicking this button will automatically fork this project so you can edit the file"
                   href="/blueimp/JavaScript-Canvas-to-Blob/edit/master/js/canvas-to-blob.js"
                   data-method="post" rel="nofollow">Edit</a>
          <a href="/blueimp/JavaScript-Canvas-to-Blob/raw/master/js/canvas-to-blob.js" class="button minibutton " id="raw-url">Raw</a>
            <a href="/blueimp/JavaScript-Canvas-to-Blob/blame/master/js/canvas-to-blob.js" class="button minibutton ">Blame</a>
          <a href="/blueimp/JavaScript-Canvas-to-Blob/commits/master/js/canvas-to-blob.js" class="button minibutton " rel="nofollow">History</a>
        </div><!-- /.button-group -->
            <a class="minibutton danger empty-icon tooltipped downwards"
               href="/blueimp/JavaScript-Canvas-to-Blob/delete/master/js/canvas-to-blob.js"
               title="Fork this project and delete file"
               data-method="post" data-test-id="delete-blob-file" rel="nofollow">
            Delete
          </a>
      </div><!-- /.actions -->

    </div>
        <div class="blob-wrapper data type-javascript js-blob-data">
        <table class="file-code file-diff">
          <tr class="file-code-line">
            <td class="blob-line-nums">
              <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>

            </td>
            <td class="blob-line-code">
                    <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/*</span></div><div class='line' id='LC2'><span class="cm"> * JavaScript Canvas to Blob 2.0.5</span></div><div class='line' id='LC3'><span class="cm"> * https://github.com/blueimp/JavaScript-Canvas-to-Blob</span></div><div class='line' id='LC4'><span class="cm"> *</span></div><div class='line' id='LC5'><span class="cm"> * Copyright 2012, Sebastian Tschan</span></div><div class='line' id='LC6'><span class="cm"> * https://blueimp.net</span></div><div class='line' id='LC7'><span class="cm"> *</span></div><div class='line' id='LC8'><span class="cm"> * Licensed under the MIT license:</span></div><div class='line' id='LC9'><span class="cm"> * http://www.opensource.org/licenses/MIT</span></div><div class='line' id='LC10'><span class="cm"> *</span></div><div class='line' id='LC11'><span class="cm"> * Based on stackoverflow user Stoive&#39;s code snippet:</span></div><div class='line' id='LC12'><span class="cm"> * http://stackoverflow.com/q/4998908</span></div><div class='line' id='LC13'><span class="cm"> */</span></div><div class='line' id='LC14'><br/></div><div class='line' id='LC15'><span class="cm">/*jslint nomen: true, regexp: true */</span></div><div class='line' id='LC16'><span class="cm">/*global window, atob, Blob, ArrayBuffer, Uint8Array, define */</span></div><div class='line' id='LC17'><br/></div><div class='line' id='LC18'><span class="p">(</span><span class="kd">function</span> <span class="p">(</span><span class="nb">window</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC19'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="s1">&#39;use strict&#39;</span><span class="p">;</span></div><div class='line' id='LC20'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">CanvasPrototype</span> <span class="o">=</span> <span class="nb">window</span><span class="p">.</span><span class="nx">HTMLCanvasElement</span> <span class="o">&amp;&amp;</span></div><div class='line' id='LC21'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nb">window</span><span class="p">.</span><span class="nx">HTMLCanvasElement</span><span class="p">.</span><span class="nx">prototype</span><span class="p">,</span></div><div class='line' id='LC22'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasBlobConstructor</span> <span class="o">=</span> <span class="nb">window</span><span class="p">.</span><span class="nx">Blob</span> <span class="o">&amp;&amp;</span> <span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC23'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="p">{</span></div><div class='line' id='LC24'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nb">Boolean</span><span class="p">(</span><span class="k">new</span> <span class="nx">Blob</span><span class="p">());</span></div><div class='line' id='LC25'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">catch</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC26'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC27'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC28'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}()),</span></div><div class='line' id='LC29'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">hasArrayBufferViewSupport</span> <span class="o">=</span> <span class="nx">hasBlobConstructor</span> <span class="o">&amp;&amp;</span> <span class="nb">window</span><span class="p">.</span><span class="nx">Uint8Array</span> <span class="o">&amp;&amp;</span></div><div class='line' id='LC30'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC31'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="p">{</span></div><div class='line' id='LC32'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nx">Blob</span><span class="p">([</span><span class="k">new</span> <span class="nx">Uint8Array</span><span class="p">(</span><span class="mi">100</span><span class="p">)]).</span><span class="nx">size</span> <span class="o">===</span> <span class="mi">100</span><span class="p">;</span></div><div class='line' id='LC33'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">catch</span> <span class="p">(</span><span class="nx">e</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC34'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="kc">false</span><span class="p">;</span></div><div class='line' id='LC35'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC36'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}()),</span></div><div class='line' id='LC37'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">BlobBuilder</span> <span class="o">=</span> <span class="nb">window</span><span class="p">.</span><span class="nx">BlobBuilder</span> <span class="o">||</span> <span class="nb">window</span><span class="p">.</span><span class="nx">WebKitBlobBuilder</span> <span class="o">||</span></div><div class='line' id='LC38'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nb">window</span><span class="p">.</span><span class="nx">MozBlobBuilder</span> <span class="o">||</span> <span class="nb">window</span><span class="p">.</span><span class="nx">MSBlobBuilder</span><span class="p">,</span></div><div class='line' id='LC39'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">dataURLtoBlob</span> <span class="o">=</span> <span class="p">(</span><span class="nx">hasBlobConstructor</span> <span class="o">||</span> <span class="nx">BlobBuilder</span><span class="p">)</span> <span class="o">&amp;&amp;</span> <span class="nb">window</span><span class="p">.</span><span class="nx">atob</span> <span class="o">&amp;&amp;</span></div><div class='line' id='LC40'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nb">window</span><span class="p">.</span><span class="nx">ArrayBuffer</span> <span class="o">&amp;&amp;</span> <span class="nb">window</span><span class="p">.</span><span class="nx">Uint8Array</span> <span class="o">&amp;&amp;</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">dataURI</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC41'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">var</span> <span class="nx">byteString</span><span class="p">,</span></div><div class='line' id='LC42'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">arrayBuffer</span><span class="p">,</span></div><div class='line' id='LC43'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">intArray</span><span class="p">,</span></div><div class='line' id='LC44'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">i</span><span class="p">,</span></div><div class='line' id='LC45'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">mimeString</span><span class="p">,</span></div><div class='line' id='LC46'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">bb</span><span class="p">;</span></div><div class='line' id='LC47'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">dataURI</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;,&#39;</span><span class="p">)[</span><span class="mi">0</span><span class="p">].</span><span class="nx">indexOf</span><span class="p">(</span><span class="s1">&#39;base64&#39;</span><span class="p">)</span> <span class="o">&gt;=</span> <span class="mi">0</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC48'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Convert base64 to raw binary data held in a string:</span></div><div class='line' id='LC49'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">byteString</span> <span class="o">=</span> <span class="nx">atob</span><span class="p">(</span><span class="nx">dataURI</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;,&#39;</span><span class="p">)[</span><span class="mi">1</span><span class="p">]);</span></div><div class='line' id='LC50'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC51'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Convert base64/URLEncoded data component to raw binary data:</span></div><div class='line' id='LC52'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">byteString</span> <span class="o">=</span> <span class="nb">decodeURIComponent</span><span class="p">(</span><span class="nx">dataURI</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;,&#39;</span><span class="p">)[</span><span class="mi">1</span><span class="p">]);</span></div><div class='line' id='LC53'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC54'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Write the bytes of the string to an ArrayBuffer:</span></div><div class='line' id='LC55'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">arrayBuffer</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">ArrayBuffer</span><span class="p">(</span><span class="nx">byteString</span><span class="p">.</span><span class="nx">length</span><span class="p">);</span></div><div class='line' id='LC56'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">intArray</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">Uint8Array</span><span class="p">(</span><span class="nx">arrayBuffer</span><span class="p">);</span></div><div class='line' id='LC57'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="p">(</span><span class="nx">i</span> <span class="o">=</span> <span class="mi">0</span><span class="p">;</span> <span class="nx">i</span> <span class="o">&lt;</span> <span class="nx">byteString</span><span class="p">.</span><span class="nx">length</span><span class="p">;</span> <span class="nx">i</span> <span class="o">+=</span> <span class="mi">1</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC58'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">intArray</span><span class="p">[</span><span class="nx">i</span><span class="p">]</span> <span class="o">=</span> <span class="nx">byteString</span><span class="p">.</span><span class="nx">charCodeAt</span><span class="p">(</span><span class="nx">i</span><span class="p">);</span></div><div class='line' id='LC59'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC60'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Separate out the mime component:</span></div><div class='line' id='LC61'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">mimeString</span> <span class="o">=</span> <span class="nx">dataURI</span><span class="p">.</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;,&#39;</span><span class="p">)[</span><span class="mi">0</span><span class="p">].</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;:&#39;</span><span class="p">)[</span><span class="mi">1</span><span class="p">].</span><span class="nx">split</span><span class="p">(</span><span class="s1">&#39;;&#39;</span><span class="p">)[</span><span class="mi">0</span><span class="p">];</span></div><div class='line' id='LC62'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Write the ArrayBuffer (or ArrayBufferView) to a blob:</span></div><div class='line' id='LC63'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">hasBlobConstructor</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC64'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="k">new</span> <span class="nx">Blob</span><span class="p">(</span></div><div class='line' id='LC65'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">[</span><span class="nx">hasArrayBufferViewSupport</span> <span class="o">?</span> <span class="nx">intArray</span> <span class="o">:</span> <span class="nx">arrayBuffer</span><span class="p">],</span></div><div class='line' id='LC66'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">{</span><span class="nx">type</span><span class="o">:</span> <span class="nx">mimeString</span><span class="p">}</span></div><div class='line' id='LC67'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">);</span></div><div class='line' id='LC68'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC69'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">bb</span> <span class="o">=</span> <span class="k">new</span> <span class="nx">BlobBuilder</span><span class="p">();</span></div><div class='line' id='LC70'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">bb</span><span class="p">.</span><span class="nx">append</span><span class="p">(</span><span class="nx">arrayBuffer</span><span class="p">);</span></div><div class='line' id='LC71'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">bb</span><span class="p">.</span><span class="nx">getBlob</span><span class="p">(</span><span class="nx">mimeString</span><span class="p">);</span></div><div class='line' id='LC72'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC73'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nb">window</span><span class="p">.</span><span class="nx">HTMLCanvasElement</span> <span class="o">&amp;&amp;</span> <span class="o">!</span><span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">toBlob</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC74'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">mozGetAsFile</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC75'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">toBlob</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">callback</span><span class="p">,</span> <span class="nx">type</span><span class="p">,</span> <span class="nx">quality</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC76'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="nx">quality</span> <span class="o">&amp;&amp;</span> <span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">toDataURL</span> <span class="o">&amp;&amp;</span> <span class="nx">dataURLtoBlob</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC77'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">callback</span><span class="p">(</span><span class="nx">dataURLtoBlob</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">toDataURL</span><span class="p">(</span><span class="nx">type</span><span class="p">,</span> <span class="nx">quality</span><span class="p">)));</span></div><div class='line' id='LC78'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC79'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">callback</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">mozGetAsFile</span><span class="p">(</span><span class="s1">&#39;blob&#39;</span><span class="p">,</span> <span class="nx">type</span><span class="p">));</span></div><div class='line' id='LC80'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC81'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC82'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="k">if</span> <span class="p">(</span><span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">toDataURL</span> <span class="o">&amp;&amp;</span> <span class="nx">dataURLtoBlob</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC83'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">CanvasPrototype</span><span class="p">.</span><span class="nx">toBlob</span> <span class="o">=</span> <span class="kd">function</span> <span class="p">(</span><span class="nx">callback</span><span class="p">,</span> <span class="nx">type</span><span class="p">,</span> <span class="nx">quality</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC84'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">callback</span><span class="p">(</span><span class="nx">dataURLtoBlob</span><span class="p">(</span><span class="k">this</span><span class="p">.</span><span class="nx">toDataURL</span><span class="p">(</span><span class="nx">type</span><span class="p">,</span> <span class="nx">quality</span><span class="p">)));</span></div><div class='line' id='LC85'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">};</span></div><div class='line' id='LC86'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC87'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC88'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="p">(</span><span class="k">typeof</span> <span class="nx">define</span> <span class="o">===</span> <span class="s1">&#39;function&#39;</span> <span class="o">&amp;&amp;</span> <span class="nx">define</span><span class="p">.</span><span class="nx">amd</span><span class="p">)</span> <span class="p">{</span></div><div class='line' id='LC89'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nx">define</span><span class="p">(</span><span class="kd">function</span> <span class="p">()</span> <span class="p">{</span></div><div class='line' id='LC90'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">return</span> <span class="nx">dataURLtoBlob</span><span class="p">;</span></div><div class='line' id='LC91'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">});</span></div><div class='line' id='LC92'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span> <span class="k">else</span> <span class="p">{</span></div><div class='line' id='LC93'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="nb">window</span><span class="p">.</span><span class="nx">dataURLtoBlob</span> <span class="o">=</span> <span class="nx">dataURLtoBlob</span><span class="p">;</span></div><div class='line' id='LC94'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="p">}</span></div><div class='line' id='LC95'><span class="p">}(</span><span class="k">this</span><span class="p">));</span></div></pre></div>
            </td>
          </tr>
        </table>
  </div>

  </div>
</div>

<a href="#jump-to-line" rel="facebox[.linejump]" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
<div id="jump-to-line" style="display:none">
  <form accept-charset="UTF-8" class="js-jump-to-line-form">
    <input class="linejump-input js-jump-to-line-field" type="text" placeholder="Jump to line&hellip;" autofocus>
    <button type="submit" class="button">Go</button>
  </form>
</div>

        </div>

      </div><!-- /.repo-container -->
      <div class="modal-backdrop"></div>
    </div><!-- /.container -->
  </div><!-- /.site -->


    </div><!-- /.wrapper -->

      <div class="container">
  <div class="site-footer">
    <ul class="site-footer-links right">
      <li><a href="https://status.github.com/">Status</a></li>
      <li><a href="http://developer.github.com">API</a></li>
      <li><a href="http://training.github.com">Training</a></li>
      <li><a href="http://shop.github.com">Shop</a></li>
      <li><a href="/blog">Blog</a></li>
      <li><a href="/about">About</a></li>

    </ul>

    <a href="/">
      <span class="mega-octicon octicon-mark-github"></span>
    </a>

    <ul class="site-footer-links">
      <li>&copy; 2013 <span title="0.05680s from github-fe121-cp1-prd.iad.github.net">GitHub</span>, Inc.</li>
        <li><a href="/site/terms">Terms</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
        <li><a href="/contact">Contact</a></li>
    </ul>
  </div><!-- /.site-footer -->
</div><!-- /.container -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
          <div class="suggester-container">
              <div class="suggester fullscreen-suggester js-navigation-container" id="fullscreen_suggester"
                 data-url="/blueimp/JavaScript-Canvas-to-Blob/suggestions/commit">
              </div>
          </div>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped leftwards" title="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped leftwards"
      title="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      <a href="#" class="octicon octicon-remove-close close ajax-error-dismiss"></a>
      Something went wrong with that request. Please try again.
    </div>

    
  </body>
</html>

