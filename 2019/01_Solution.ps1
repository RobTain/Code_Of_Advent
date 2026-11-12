# Teamcity configuration
Set-StrictMode -Version Latest

# Error Handler
$ErrorActionPreference = "Stop"

# Functions
function GetPuzzleInput {
    [CmdletBinding()]
    param ()
    
    # $PSCommandPath get full path of the script 
    $path = $PSCommandPath.Replace("Solution.ps1","Input.txt")
    return (Get-Content -Path $path)
}

function CalculateFuel_Puzzle_01 {
    [CmdletBinding()]
    param ([int]$value) 
    return [math]::Truncate((([int]$value/3)-2)/1)
}

function CalculateFuel_Puzzle_02 {
    [CmdletBinding()]
    param ([int]$value)
    
    $result = 0
    while ($true) {
        $value = CalculateFuel_Puzzle_01 $value
        if ($value -gt 0) { $result += $value } else { break }
    }
    return $result 
}



function Main {
    [CmdletBinding()]
    param () 

    Write-Host "[INFO] Get Puzzle Input" -ForegroundColor Green
    $input = GetPuzzleInput

    Write-Host "[INFO] Solve Puzzle 01"
    foreach ($line in $input) { [int]$result += CalculateFuel_Puzzle_01 ([int]$line) }
    Write-Host "[INFO] Solution Puzzle 01: $result" -ForegroundColor Green

    [int]$result = 0
    Write-Host "[INFO] Solve Puzzle 02"
    foreach ($line in $input) { [int]$result += CalculateFuel_Puzzle_02 $line }
    
    Write-Host "[INFO] Solution Puzzle 02: $result" -ForegroundColor Green
}

# Main
Main 