<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />
    <#include "activity_layout_recipe.xml.ftl" />
    <merge from="AndroidManifest.xml.ftl"
        to="${escapeXmlAttribute(manifestOut)}/AndroidManifest.xml" />

<#if generateKotlin>
    <instantiate from="src/app_package/classes/Activity.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.kt" />
    
    <instantiate from="src/app_package/classes/ViewModel.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.kt"/>

<#else>
    <instantiate from="src/app_package/classes/Activity.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.java" />
    <open file="${escapeXmlAttribute(srcOut)}/activity/${className}Activity.java" />
    
    <instantiate from="src/app_package/classes/ViewModel.java.ftl"
    to="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.java" />
    <open file="${escapeXmlAttribute(srcOut)}/viewmodel//${className}ViewModel.java"/>
</#if>

    <instantiate from="src/app_package/classes/Provider.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/dataprovider/${className}DataProvider.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/dataprovider/${className}DataProvider.kt"/>
    
    <instantiate from="src/app_package/classes/Model.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/models/binding/${className}BindingModel.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/models/binding/${className}BindingModel.kt"/>

</recipe>
