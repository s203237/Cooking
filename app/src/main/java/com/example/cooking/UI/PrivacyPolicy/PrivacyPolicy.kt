
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicy() {
    Box (

        modifier= Modifier
            .fillMaxSize()
            .background(color = Color(0xFFB8C75E))
    ) {

        Image(
            painter = painterResource(id = R.drawable.apple),
            contentDescription = "apple icon",
            modifier = Modifier
                .size(230.dp)
                .offset(250.dp, 150.dp)
                .rotate(-45f)
        )
        Image(
            painter = painterResource(id = R.drawable.lyn),
            contentDescription = "lyn icon",
            modifier = Modifier
                .size(175.dp)
                .offset(-(50).dp, -(50).dp)
        )
        val privacyPolicyText = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Effective Date:")
            }
            append(" [06-11-2023]\n\n")

            append("Vegelicious is committed to safeguarding your privacy. This Privacy Policy explains how we collect, use, and protect your personal information when you use our app.\n\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Information We Collect:\n")
            }
            append("- Personal Information: We may collect personal information, including your name and email address, when you create an account or contact us.\n")
            append("- Usage Data: We collect information about how you use Vegelicious, such as the features you access, the recipes you view, and your interactions with our app.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("How We Use Your Information\n")
            }
            append("We use the collected information to:\n")
            append("- Improve Our Service: We analyze user data to enhance and personalize your experience on Vegelicious.\n")
            append("- Communication: We may send you emails or notifications about updates, new features, or important information related to the app.\n")
            append("- Research and Analytics: We may use your data for research and analytics to better understand our users' needs and preferences.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Sharing Your Information\n")
            }
            append("We do not share your personal information with third parties except in the following cases:\n")
            append("- With Your Consent: If you grant us permission to share your information.\n")
            append("- For Legal Reasons: To comply with applicable laws and regulations or respond to lawful requests.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Data Security\n")
            }
            append("We are committed to ensuring the security of your data. We implement measures to protect your information from unauthorized access, disclosure, and alteration.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Your Choices\n")
            }
            append("You have the right to:\n")
            append("- Access, correct, or delete your personal information.\n")
            append("- Opt-out of marketing communications.\n")
            append("- Disable cookies or tracking through your device settings.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Changes to Privacy Policy\n")
            }
            append("We may update this Privacy Policy from time to time. You will be notified of any changes, and the latest version will be posted here.\n")

            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append("Contact Us\n")
            }
            append("If you have any questions or concerns about our Privacy Policy, please contact us.\n")

            append("Thank you for choosing Vegelicious.\n")
            append("We are dedicated to providing you with a positive and safe user experience.")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(

                text = "Privacy Policy",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = privacyPolicyText,
                fontSize = 16.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PrivacyPolicyPreview() {
    PrivacyPolicy()
}