# StateButton
[![JitPack](https://img.shields.io/badge/jitpack-v0.1.2-brightgreen.svg)](https://jitpack.io/#yuzumone/StateButton/)
[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

StateButton is an android library that the button component has a boolean value.

## Demo
![Demo](./demo.gif)

## Gradle
### Repository
Add this to your root `build.gradle` file.
```gradle
allprojects {
    repositories {
         ...
         maven { url 'https://jitpack.io' }
    }
}
```

### Dependency
Add this to your app `build.gradle` file.
```gradle
dependencies {
    ...
    compile 'com.github.yuzumone:StateButton:0.1.2'
}
```

## Usage
### XML
```xml
<net.yuzumone.statebutton.StateButton
    android:id="@+id/state_button"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    />
```

### Attributes
```xml
<net.yuzumone.statebutton.StateButton
    app:state="true"
    app:trueText="True"
    app:falseText="False"
    />
```

## ButtonState
To set a init state of the button you use the setState functionality via xml or java. Default value is false.

### XML
```xml
app:state="true"
or
app:state="false"
```

### Java
```java
stateButton.setState(true);
or
stateButton.setState(false);
```

## ButtonText
To set text of the button you use the setTrueText or setFalseText functionality via xml or java. You can use String or String Resource.

### XML
```xml
app:trueText="True"
or
app:trueText="@string/true_string"
```

### Java
```java
stateButton.setTrueText("True");
or
stateButton.setTrueText(R.string.true_string);
```

## OnStateButtonListener
By setting a listener you will receive events accroding to the state.

```java
stateButton.setOnStateButtonListener(new OnStateButtonListener() {
    @Override
    public void trued(StateButton stateButton) {
    
    }

    @Override
    public void falsed(StateButton stateButton) {
    
    }
});
```

## License
```
Copyright 2017 yuzumone

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```