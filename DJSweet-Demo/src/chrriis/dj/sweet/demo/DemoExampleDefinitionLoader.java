/*
 * Christopher Deckers (chrriis@nextencia.net)
 * http://www.nextencia.net
 * 
 * See the file "readme.txt" for information on usage and redistribution of
 * this file, and for a DISCLAIMER OF ALL WARRANTIES.
 */
package chrriis.dj.sweet.demo;

import java.util.ArrayList;
import java.util.List;

import chrriis.dj.sweet.demo.examples.flashplayer.FunctionCalls;
import chrriis.dj.sweet.demo.examples.flashplayer.SimpleFlashExample;
import chrriis.dj.sweet.demo.examples.flashplayer.VariablesAndFlow;
import chrriis.dj.sweet.demo.examples.htmleditor.CustomConfiguration;
import chrriis.dj.sweet.demo.examples.htmleditor.SimpleHTMLEditorExample;
import chrriis.dj.sweet.demo.examples.htmleditor.TinyMCEExample;
import chrriis.dj.sweet.demo.examples.syntaxhighlighter.SimpleSyntaxHighlighterExample;
import chrriis.dj.sweet.demo.examples.vlcplayer.SimpleVLCPlayerExample;
import chrriis.dj.sweet.demo.examples.webbrowser.ClasspathPages;
import chrriis.dj.sweet.demo.examples.webbrowser.JavascriptExecution;
import chrriis.dj.sweet.demo.examples.webbrowser.NavigationControl;
import chrriis.dj.sweet.demo.examples.webbrowser.SendingCommands;
import chrriis.dj.sweet.demo.examples.webbrowser.SettingContent;
import chrriis.dj.sweet.demo.examples.webbrowser.SimpleWebBrowserExample;
import chrriis.dj.sweet.demo.examples.webbrowser.XPCOMDownloadManager;
import chrriis.dj.sweet.demo.examples.webbrowser.XPCOMToggleEditionMode;
import chrriis.dj.sweet.demo.examples.win32.multimediaplayer.SimpleWMediaPlayerExample;

/**
 * @author Christopher Deckers
 */
public class DemoExampleDefinitionLoader {

  public static List<ExampleGroup> getExampleGroupList() {
    boolean isXULRunnerPresent = System.getProperty("nativeswing.webbrowser.xulrunner.home") != null || System.getenv("XULRUNNER_HOME") != null;
    String xulRunnerErrorMessage = "Mozilla XULRunner is required to run this example.\n\nPlease download it and either set the \"XULRUNNER_HOME\" environment variable\nor the \"nativeswing.webbrowser.xulrunner.home\" system property.\n(Make sure that \"javaxpcom.jar\" is part of your XULRunner install)";
    List<ExampleGroup> exampleGroupList = new ArrayList<ExampleGroup>();
//    exampleGroupList.add(new ExampleGroup("Introduction", new Example[] {
//        new Example("Native Integration", NativeIntegration.class, "First, some background information on the problems of native integration in a Swing-based application.", false),
//        new Example("The Solution", TheSolution.class, "The DJ Project - NativeSwing.", false),
//        new Example("Codewise", Codewise.class, "How hard is it to code using this library?", false),
//    }));
    exampleGroupList.add(new ExampleGroup("JWebBrowser", new Example[] {
        new Example("Simple Example", SimpleWebBrowserExample.class, "This is a simple example that shows the basic configuration of an embedded web browser component.", true),
        new Example("Setting Content", SettingContent.class, "Set any HTML content to the web browser.", true),
        new Example("Javascript Execution", JavascriptExecution.class, "Execute some Javascript code in the current web browser page.", true),
        new Example("Navigation Control", NavigationControl.class, "Control the navigation happening in the web browser from the Java application.\nThis allows to block certain links and/or the creation of new windows, or to open links and/or new windows elsewhere.", true),
        new Example("Sending Commands", SendingCommands.class, "Use static links or simple Javascript to send some commands with arguments to the application:\n    function sendCommand(command) {\n      var s = 'command://' + encodeURIComponent(command);\n      for(var i=1; i<arguments.length; s+='&'+encodeURIComponent(arguments[i++]));\n      window.location = s;\n    }", true),
        new Example("Classpath pages", ClasspathPages.class, "Load web pages from the classpath with the help of the embedded simple web server.", true),
        new Example("Mozilla XPCOM Page Edition", XPCOMToggleEditionMode.class, "Toggle edition mode of a web page by accessing the Mozilla interfaces using XPCOM.", true, isXULRunnerPresent, xulRunnerErrorMessage),
        new Example("Mozilla XPCOM Download Manager", XPCOMDownloadManager.class, "Modify the browser's download manager using Mozilla XPCOM.", true, isXULRunnerPresent, xulRunnerErrorMessage),
    }));
    exampleGroupList.add(new ExampleGroup("JFlashPlayer", new Example[] {
        new Example("Simple Example", SimpleFlashExample.class, "Display a Flash application.", true),
        new Example("Variables and Flow", VariablesAndFlow.class, "Control the flow of a Flash animation, and get/set global variables.", true),
        new Example("Function Calls", FunctionCalls.class, "Invoke functions, with or without waiting for a result, and listen to Flash commands.", true),
    }));
    exampleGroupList.add(new ExampleGroup("JVLCPlayer", new Example[] {
        new Example("Simple Example", SimpleVLCPlayerExample.class, "Load a movie/sound file to an embedded VLC player.", true),
    }));
    exampleGroupList.add(new ExampleGroup("JHTMLEditor", new Example[] {
        new Example("Simple Example", SimpleHTMLEditorExample.class, "Graphically edit some HTML, get and set the HTML content.", true),
        new Example("Custom Configuration", CustomConfiguration.class, "Modify default behaviors with custom configuration script.", true),
        new Example("TinyMCE implementation", TinyMCEExample.class, "Use the TinyMCE editor implementation instead of the default FCKeditor.", true),
    }));
    exampleGroupList.add(new ExampleGroup("JSyntaxHighlighter", new Example[] {
        new Example("Simple Example", SimpleSyntaxHighlighterExample.class, "Display some content with syntax highlighting from one of the available languages (C++, C#, css, Delphi, Java, JS, PHP, Python, Ruby, SQL, VB, XML, HTML).", true),
    }));
    exampleGroupList.add(new ExampleGroup("JWMediaPlayer (win32)", new Example[] {
        new Example("Simple Example", SimpleWMediaPlayerExample.class, "Load a movie/sound file to an embedded multimedia player.", true, System.getProperty("os.name").startsWith("Windows"), "This example is only available on a Windows operating system."),
    }));
    return exampleGroupList;
  }
  
}
