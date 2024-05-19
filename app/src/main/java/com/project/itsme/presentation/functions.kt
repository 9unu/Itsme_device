package com.project.itsme.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Message
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip
import com.project.itsme.presentation.theme.WearAppTypography

// 버튼 만들기
@Composable
fun ButtonExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier
) {
    Row(    // 버튼을 중간에 오도록
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        // Button
        Button(
            modifier = Modifier.size(ButtonDefaults.LargeButtonSize),//os크기에 최적화된 버튼 크기
            onClick = { /* ... */ },//버튼 클릭되었을 때 어떻게 할지
        ) {
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "triggers phone action",
                modifier = iconModifier
            )
        }
    }
}
// 텍스트 행 추가
@Composable
fun TextExample(modifier: Modifier = Modifier) {
    Text(   // 문장 추가
        modifier = modifier,
        textAlign = TextAlign.Center,   //가운데 정렬
        color = MaterialTheme.colors.primary,//색상 지정
        text = stringResource(com.project.itsme.R.string.device_shape) //strings.xml에 device_shape이라고 정의된 문장
    )
}

@Composable
fun CardExample(
    modifier: Modifier = Modifier,
    iconModifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    AppCard(
        modifier = modifier,
        appImage = {
            Icon(
                imageVector = Icons.Rounded.Message,
                contentDescription = "triggers open message action",
                modifier = iconModifier
            )
        },
        appName = { Text("Kakao") },
        time = { Text("now") },
        title = { Text("여자친구") },
        onClick = onClick
    ) {
        Text("어디야?")
    }
}

@Composable
fun ChipExample(
    modifier: Modifier = Modifier,
    chip_text: String // 각 Chip에 표시할 텍스트 목록
) {
    Chip(
        modifier = modifier
            .heightIn(max = 50.dp) // chip 한칸당 높이
            .fillMaxWidth(),        // 가로는 최대 길이
        onClick = { /* ... */ },
        label = {
            Text(
                text = chip_text,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = WearAppTypography.body2
            )
        },
    )
}

@Composable
fun ToggleChipExample(modifier: Modifier = Modifier) {
    var checked by remember { mutableStateOf(true) }
    ToggleChip(
        modifier = modifier,
        checked = checked,  //활성화/비활성화 버튼
        toggleControl = {
            Switch(
                checked = checked,
                modifier = Modifier.semantics {
                    this.contentDescription = if (checked) "On" else "Off"
                }
            )
        },
        onCheckedChange = {
            checked = it
        },
        label = {
            Text(
                text = "Sound", // 버튼 이름
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )
}

@Composable
fun StartOnlyTextComposables() {
    Text(
        modifier = Modifier.fillMaxSize(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = stringResource(com.project.itsme.R.string.hello_world)
    )
}