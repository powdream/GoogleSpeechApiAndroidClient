package jerry.speechapi.service;

import android.support.annotation.NonNull;

import java.util.List;

import jerry.speechapi.auth.Authentication;
import jerry.speechapi.client.RecognitionRequest;
import jerry.speechapi.client.result.SpeechRecognitionResult;
import retrofit2.Call;
import rx.Single;

final class ApiKeyAuthenticationSpeechApiBridge implements AuthenticationSpeechApiBridge {
    @Override
    public Call<List<SpeechRecognitionResult>> recognize(
            @NonNull SpeechApi speechApi,
            @NonNull Authentication auth,
            @NonNull RecognitionRequest request) {
        return speechApi.recognizeWithApiKey(auth.getToken(), request);
    }

    @Override
    public Single<List<SpeechRecognitionResult>> recognizeAsSingle(
            @NonNull SpeechApi speechApi,
            @NonNull Authentication auth,
            @NonNull RecognitionRequest request) {
        return speechApi.recognizeWithApiKeyAsSingle(auth.getToken(), request);
    }
}
