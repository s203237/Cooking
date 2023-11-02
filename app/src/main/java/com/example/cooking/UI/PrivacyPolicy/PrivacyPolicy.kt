
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicy() {
    val privacyPolicyText = """
        Privacy Policy
        
        Effective Date: [Date]
        
        Vegelicious is committed to safeguarding your privacy. This Privacy Policy explains how we collect, use, and protect your personal information when you use our app.
        
        Information We Collect
        
        - Personal Information: We may collect personal information, including your name and email address, when you create an account or contact us.
        
        - Usage Data: We collect information about how you use Vegelicious, such as the features you access, the recipes you view, and your interactions with our app.
        
        How We Use Your Information
        
        We use the collected information to:
        
        - Improve Our Service: We analyze user data to enhance and personalize your experience on Vegelicious.
        
        - Communication: We may send you emails or notifications about updates, new features, or important information related to the app.
        
        - Research and Analytics: We may use your data for research and analytics to better understand our users' needs and preferences.
        
        Sharing Your Information
        
        We do not share your personal information with third parties except in the following cases:
        
        - With Your Consent: If you grant us permission to share your information.
        
        - For Legal Reasons: To comply with applicable laws and regulations or respond to lawful requests.
        
        Data Security
        
        We are committed to ensuring the security of your data. We implement measures to protect your information from unauthorized access, disclosure, and alteration.
        
        Your Choices
        
        You have the right to:
        
        - Access, correct, or delete your personal information.
        
        - Opt-out of marketing communications.
        
        - Disable cookies or tracking through your device settings.
        
        Changes to Privacy Policy
        
        We may update this Privacy Policy from time to time. You will be notified of any changes, and the latest version will be posted here.
        
        Contact Us
        
        If you have any questions or concerns about our Privacy Policy, please contact us at [Your Contact Information].
        
        Thank you for choosing Vegelicious. We are dedicated to providing you with a positive and safe user experience.
    """.trimIndent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Privacy Policy",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold ,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = privacyPolicyText,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PrivacyPolicyPreview() {
    PrivacyPolicy()
}
