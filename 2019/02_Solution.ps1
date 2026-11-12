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

function Puzzle01 {
    [CmdletBinding()]
    param ($input) 

    return 0
}

function Puzzle02 {
    [CmdletBinding()]
    param ($input)

    return 0 
}



function Main {
    [CmdletBinding()]
    param () 

    Write-Host "[INFO] Get Puzzle Input" -ForegroundColor Green
    $input = GetPuzzleInput

    echo $input
    Write-Host "[INFO] Solve Puzzle 01"
    $result = Puzzle01 $input
    Write-Host "[INFO] Solution Puzzle 01: $result" -ForegroundColor Green

    [int]$result = 0
    Write-Host "[INFO] Solve Puzzle 02"
    $result = Puzzle02 $input
    Write-Host "[INFO] Solution Puzzle 02: $result" -ForegroundColor Green
}

# Main
Main 