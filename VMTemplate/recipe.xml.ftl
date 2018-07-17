<?xml version="1.0"?>
<#import "root://activities/common/kotlin_macros.ftl" as kt>
<recipe>
    <@kt.addAllKotlinDependencies />
<#if generateVM>
    <#if generateKotlin>
        <instantiate from="src/app_package/classes/ViewModel.kt.ftl"
        to="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.kt" />
        <open file="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.kt"/>

    <#else>
        <instantiate from="src/app_package/classes/ViewModel.java.ftl"
        to="${escapeXmlAttribute(srcOut)}/viewmodel/${className}ViewModel.java" />
        <open file="${escapeXmlAttribute(srcOut)}/viewmodel//${className}ViewModel.java"/>
    </#if>
    <instantiate from="src/app_package/classes/Model.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/models/binding/${className}BindingModel.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/models/binding/${className}BindingModel.kt"/>
</#if>
    <instantiate from="src/app_package/classes/Provider.kt.ftl"
    to="${escapeXmlAttribute(srcOut)}/dataprovider/${className}DataProvider.kt" />
    <open file="${escapeXmlAttribute(srcOut)}/dataprovider/${className}DataProvider.kt"/>

</recipe>
