<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />
    <#include "activity_layout_recipe.xml.ftl" />

<#if generateKotlin>
    <instantiate from="src/app_package/classes/Activity.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.kt" />
    
    <instantiate from="src/app_package/classes/Presenter.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/presenter/${className}Presenter.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/presenter//${className}Presenter.kt"/>
<#else>
    <instantiate from="src/app_package/classes/Activity.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.java" />
    <open file="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.java" />
    
    <instantiate from="src/app_package/classes/Presenter.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/presenter/${className}Presenter.java" />
    <open file="${escapeXmlAttribute(srcOut)}/presenter//${className}Presenter.java"/>
</#if>
    
    <instantiate from="src/app_package/classes/Interface.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/uiinterface/I${className}Ui.java" />
    <open file="${escapeXmlAttribute(srcOut)}/uiinterface/I${className}Ui.java" />


</recipe>
