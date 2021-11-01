// Copyright Epic Games, Inc. All Rights Reserved.

#pragma once

#include <activation.h>
#include <fstream>
#include <shlobj_core.h>
#include <string>
#include <vector>

using namespace std;

#include "CoreMinimal.h"
#include "GameFramework/GameModeBase.h"
#include "MinecraftToUE4GameModeBase.generated.h"

/**
 * 
 */
UCLASS()
class MINECRAFTTOUE4_API AMinecraftToUE4GameModeBase : public AGameModeBase
{
	GENERATED_BODY()
	
public:
	UFUNCTION(BlueprintCallable, Category = "Game Functions")
    	TArray<FString> getLines(FString fileLocation);

private:

	std::string getDocumentsFolder()
	{

		// Credit to: https://stackoverflow.com/questions/2414828/get-path-to-my-documents
		
		PWSTR   ppszPath;    // variable to receive the path memory block pointer.

		HRESULT hr = SHGetKnownFolderPath(FOLDERID_Documents, 0, NULL, &ppszPath);
		
		std::wstring myPath;
		
		if (SUCCEEDED(hr)) {
			myPath = ppszPath;      // make a local copy of the path
		}

		CoTaskMemFree(ppszPath);    // free up the path memory block

		const std::string path(myPath.begin(), myPath.end());

		return path;
	}
	
};
