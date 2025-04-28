package com.example.liveregiontest.webview

import android.view.ViewGroup
import android.webkit.WebView
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.liveregiontest.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebView() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Start menu")}) },
        bottomBar = { Button() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(20.dp),
        ) {
            item { ComposeWebView() }
            item {
                Text(
                    text = "Item 2",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun Button() {
    TextButton(content = { Text(text = "Button") }, onClick = {})
}

@Composable
private fun ComposeWebView(modifier: Modifier = Modifier) {
        AndroidView(
            modifier = modifier.padding(horizontal = 16.dp),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                    )

                    setBackgroundColor(context.getColor(R.color.white))

                loadDataWithBaseURL(
                    "file:///android_asset/",
                    sourceHtmlContent,
                    "text/html",
                    "UTF-8",
                    null,
                )
            }
            },
        )
}

private val sourceHtmlContent = """
<p>Welcome to our platform, designed to empower businesses with innovative tools and solutions. Our mission is to streamline operations and enhance productivity through cutting-edge technology. With a focus on user experience, our services are tailored to meet the diverse needs of modern enterprises. Whether you're a small startup or a global corporation, our solutions adapt to your unique challenges. We prioritize reliability, ensuring that every feature is robust and intuitive. By leveraging advanced analytics, we help you make informed decisions that drive growth. Our team is dedicated to supporting you at every step, from onboarding to long-term success.</p>

<p>Our platform offers a wide range of features to simplify complex workflows. With seamless integration capabilities, you can connect your existing tools and systems effortlessly. Real-time collaboration tools enable teams to work together, no matter where they are located. We understand the importance of security, which is why our infrastructure is built with industry-leading encryption and compliance standards. Regular updates ensure that you always have access to the latest innovations. Our customizable dashboards provide insights into key performance metrics, helping you stay ahead of the competition. Explore our solutions today and discover how we can transform your operations.</p>

<p>Data is at the heart of every successful business, and our platform makes it easy to harness its power. Our advanced analytics tools provide deep insights into customer behavior and market trends. With flexible reporting options, you can visualize data in ways that matter most to your team. We also offer automated workflows to save time on repetitive tasks. Our commitment to scalability means that as your business grows, our platform grows with you. From startups to enterprises, we provide the tools you need to succeed in a fast-paced world. Let us help you unlock the full potential of your data.</p>

<p>Collaboration is key to innovation, and our platform is designed to foster teamwork. Our intuitive interface makes it easy for teams to share ideas and manage projects efficiently. With built-in communication tools, you can keep everyone aligned on goals and deadlines. We also offer version control features to ensure that your work is always up to date. Our platform supports both synchronous and asynchronous collaboration, giving your team the flexibility to work on their terms. By reducing friction in workflows, we help you deliver projects faster. Join thousands of teams who trust us to power their collaboration.</p>

<p>Security and compliance are non-negotiable in today's digital landscape. Our platform is built with robust safeguards to protect your data and ensure regulatory compliance. From encryption to access controls, we implement best practices to keep your information safe. Regular audits and monitoring help us maintain a secure environment. We also provide detailed documentation to help you meet industry standards. Our dedicated support team is available to answer any questions about security or compliance. With our platform, you can focus on your business with peace of mind. Trust us to keep your data secure.</p>

<p>Customer success is at the core of everything we do. Our support team is available around the clock to assist with any questions or challenges. We offer comprehensive onboarding programs to help you get started quickly. Our knowledge base and tutorials provide resources for self-guided learning. For more complex needs, our consulting services offer personalized guidance. We also gather feedback to continuously improve our platform and services. Our goal is to build long-lasting partnerships with our clients. Contact us today to learn how we can support your business goals.</p>

<p>Innovation drives our platform, and we're constantly evolving to meet your needs. Our research and development team explores new technologies to enhance our offerings. We incorporate user feedback to ensure that every update delivers value. Our modular architecture allows you to choose the features that matter most to your business. With a focus on performance, our platform delivers fast and reliable results. We also partner with leading technology providers to expand our capabilities. Stay ahead of the curve with a platform that's built for the future. Explore our latest features and see what's possible.</p>

<p>We believe in empowering our clients with tools that make a difference. Our platform is designed to be accessible, with support for multiple languages and devices. Whether you're in the office or on the go, you can access our tools with ease. Our pricing plans are flexible, allowing you to scale as your needs change. We also offer free trials to help you evaluate our platform risk-free. With a global community of users, we're proud to support businesses worldwide. Get started today and experience the difference our platform can make. Your success is our priority.</p>
""".trimIndent()