// Copyright Epic Games, Inc. All Rights Reserved.


#include "MinecraftToUE4GameModeBase.h"

TArray<FString> AMinecraftToUE4GameModeBase::getLines(FString fileLocation)
{
	TArray<FString> strings;

	std::string documentsFolder = getDocumentsFolder();
	std::string fileLocationSTR = TCHAR_TO_UTF8(*fileLocation);

	std::ifstream file(getDocumentsFolder() + "\\MinecraftToUE4\\" + std::string(TCHAR_TO_UTF8(*fileLocation)));
	std::string str;
	// Loop through all the lines, setting str as the current line.
	while (std::getline(file, str))
	{
		strings.Add(str.c_str());
	}

	// Even though file will close itself, call this just in-case.
	file.close();

	// Disabled as not needed.
	//UE_LOG(LogTemp, Display, TEXT("Line count: %d"), strings.Num());

	return strings;
}


